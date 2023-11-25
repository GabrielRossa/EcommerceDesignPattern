import cart.CartItem;
import cart.CheckoutInfo;
import itens.Item;
import cart.ShoppingCart;
import observer.Observer;
import observer.Subject;
import org.example.payment.PaymentProvider;

import java.util.ArrayList;
import java.util.List;

public class ECommerce {
    private final PaymentProvider paymentProvider;
    private final ShoppingCart shoppingCart;
    private final Subject orderSubject;
    private List<Observer> logisticsAgents;

    public ECommerce(PaymentProvider paymentProvider, ShoppingCart shoppingCart, Subject orderSubject) {
        this.paymentProvider = paymentProvider;
        this.shoppingCart = shoppingCart;
        this.orderSubject = orderSubject;
        this.logisticsAgents = new ArrayList<>();
    }

    public void addLogisticsAgent(Observer logisticsAgent) {
        logisticsAgents.add(logisticsAgent);
    }

    public void addToCart(Item item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        shoppingCart.addItem(cartItem);
        System.out.println(quantity + " " + item.getName() + "(s) added to the shopping cart.");
    }

    public void checkout() {
        double totalAmount = shoppingCart.calculateTotal();

        // Adiciona os agentes logísticos
        for (Observer logisticsAgent : logisticsAgents) {
            orderSubject.attach(logisticsAgent);
        }

        CheckoutInfo checkoutInfo = new CheckoutInfo(shoppingCart.getCartItems(), totalAmount);

        // Modificação para incluir informações do carrinho no setDeliveryInfo
        orderSubject.setDeliveryInfo(checkoutInfo);

        // Lógica adicional de checkout, como processar pagamento, enviar confirmação, etc.
        paymentProvider.processPayment(totalAmount);

        // Limpar o carrinho após o checkout
        shoppingCart.getCartItems().clear();
    }
}