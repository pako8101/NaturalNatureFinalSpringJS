package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
public class Subscription extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user; // Връзка с User ентити

    private String stripeSessionId; // ID на сесията от Stripe
    private String status; // "active", "pending", "canceled"
    private LocalDateTime subscriptionDate;
    private Double amount;

    public Subscription() {
    }

    public UserEntity getUser() {
        return user;
    }

    public Subscription setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getStripeSessionId() {
        return stripeSessionId;
    }

    public Subscription setStripeSessionId(String stripeSessionId) {
        this.stripeSessionId = stripeSessionId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Subscription setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public Subscription setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Subscription setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
