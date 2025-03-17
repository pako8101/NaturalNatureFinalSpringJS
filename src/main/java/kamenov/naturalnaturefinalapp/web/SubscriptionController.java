package kamenov.naturalnaturefinalapp.web;

import com.stripe.model.checkout.Session;
import com.stripe.Stripe;

import com.stripe.param.checkout.SessionCreateParams;

import kamenov.naturalnaturefinalapp.entity.Subscription;
import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class SubscriptionController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    private final SubscriptionService subscriptionService;
@Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }


    @GetMapping("/subscribe")
    public String getSubscriptionPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            UserEntity user = (UserEntity) auth.getPrincipal(); // Предполагам, че User е в SecurityContext
            model.addAttribute("userEmail", user.getEmail());
        }
        return "subscribe";
    }

    @PostMapping("/create-checkout-session")
    public String createCheckoutSession(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
            model.addAttribute("error", "Please log in to subscribe.");
            return "subscribe";
        }

        try {
            UserEntity user = (UserEntity) auth.getPrincipal();
            Stripe.apiKey = stripeApiKey;

            SessionCreateParams params = SessionCreateParams.builder()
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setPrice("${stripe.api.key}") // Замени с твоя Price ID
                                    .setQuantity(1L)
                                    .build()
                    )
                    .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                    .setSuccessUrl("http://localhost:8029/subscription-confirmation?session_id={CHECKOUT_SESSION_ID}")
                    .setCancelUrl("http://localhost:8029/subscribe")
                    .setCustomerEmail(user.getEmail()) // Изпращаме email към Stripe
                    .build();

            Session session = Session.create(params);

            Subscription subscription = new Subscription();
            subscription.setUser(user);
            subscription.setStripeSessionId(session.getId());
            subscription.setStatus("pending");
            subscription.setSubscriptionDate(LocalDateTime.now());
            subscription.setAmount(9.99);
            subscriptionService.saveSubscription(subscription);

            return "redirect:" + session.getUrl();
        } catch (Exception e) {
            model.addAttribute("error", "Error creating checkout session: " + e.getMessage());
            return "subscribe";
        }
    }

    @GetMapping("/subscription-confirmation")
    public String getSubscriptionConfirmation(Model model, @RequestParam(value = "session_id", required = false) String sessionId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (sessionId != null && auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            try {
                Stripe.apiKey = stripeApiKey;
                Session session = Session.retrieve(sessionId);
                Subscription subscription = subscriptionService.findByStripeSessionId(sessionId);
                if (subscription != null) {
                    subscription.setStatus("active");
                    subscriptionService.saveSubscription(subscription);
                    UserEntity user = (UserEntity) auth.getPrincipal();
                    model.addAttribute("message", "Subscription successful! Welcome to Eco Life Premium Membership, " + user.getEmail() + ". Subscription ID: " + subscription.getId());
                } else {
                    model.addAttribute("message", "Subscription not found in our records.");
                }
            } catch (Exception e) {
                model.addAttribute("message", "Error verifying subscription: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Please log in or subscription session is missing.");
        }
        return "subscription-confirmation";
    }
}
