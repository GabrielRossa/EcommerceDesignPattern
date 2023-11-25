import itens.Item;
import itens.Product;
import cart.ShoppingCart;
import itens.Service;
import logistic.LogisticsAgent;
import observer.Observer;
import observer.Subject;
import org.example.payment.PayPalPaymentProvider;
import org.example.payment.PaymentProvider;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance();

        PaymentProvider paypalProvider = new PayPalPaymentProvider();
        Subject orderSubject = new Subject();

        ECommerce ecommerce = new ECommerce(paypalProvider, cart, orderSubject);

        Observer logisticsAgent1 = new LogisticsAgent("Agent 1");
        Observer logisticsAgent2 = new LogisticsAgent("Agent 2");

        ecommerce.addLogisticsAgent(logisticsAgent1);
        ecommerce.addLogisticsAgent(logisticsAgent2);

        // Adicionando produtos e serviços ao carrinho
        Item productA = new Product("Product A", 25.0);
        Item serviceB = new Service("Service B", 50.0);

        ecommerce.addToCart(productA, 2);
        ecommerce.addToCart(serviceB, 1);

        // Realizando o checkout
        ecommerce.checkout();

        // Simulação de cancelamento de pedido
        orderSubject.cancelOrder();
    }
}