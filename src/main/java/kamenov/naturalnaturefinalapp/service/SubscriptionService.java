package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.Subscription;

public interface SubscriptionService {
    Subscription saveSubscription(Subscription subscription);

    Subscription findByStripeSessionId(String stripeSessionId);
}
