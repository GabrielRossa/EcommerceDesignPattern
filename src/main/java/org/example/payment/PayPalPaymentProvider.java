package org.example.payment;

public class PayPalPaymentProvider implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of amount: " + amount);
        // Implementação específica do PayPal
    }
}