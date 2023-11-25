package observer;

import cart.CheckoutInfo;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private CheckoutInfo checkoutInfo;
    private boolean isCancelled;

    public CheckoutInfo getCheckoutInfo() {
        return checkoutInfo;
    }

    public void setDeliveryInfo(CheckoutInfo checkoutInfo) {
        this.checkoutInfo = checkoutInfo;
        notifyAllObservers("Informações de entrega: " + checkoutInfo.getTotalAmount() +
                " - Resumo do pedido: " + checkoutInfo.getCartItems());
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancelOrder() {
        isCancelled = true;
        notifyAllObservers("Pedido cancelado");
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}