package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.Subscription;
import kamenov.naturalnaturefinalapp.repositories.SubscriptionRepository;
import kamenov.naturalnaturefinalapp.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription findByStripeSessionId(String stripeSessionId) {
        return subscriptionRepository.findByStripeSessionId(stripeSessionId);
    }
}
