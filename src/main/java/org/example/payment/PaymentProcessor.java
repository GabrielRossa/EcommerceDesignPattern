package org.example.payment;

class PaymentProcessor {
    private PaymentProvider paymentProvider;

    // Injeção de dependência via construtor
    public PaymentProcessor(PaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    public void processPayment(double amount) {
        paymentProvider.processPayment(amount);
    }
}