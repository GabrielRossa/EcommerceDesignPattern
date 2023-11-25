package org.example.payment;

public class PixPaymentProvider implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of amount: " + amount);
        // Implementação específica do Stripe
    }
}
