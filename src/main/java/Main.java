import itens.Item;
import itens.Product;
import cart.ShoppingCart;
import itens.Service;
import org.example.payment.PayPalPaymentProvider;
import org.example.payment.PaymentProvider;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance();

        PaymentProvider paypalProvider = new PayPalPaymentProvider();
        ECommerce ecommerce = new ECommerce(paypalProvider, cart);

        Item productA = new Product("Product A", 25.0);
        Item serviceB = new Service("Service B", 50.0);

        ecommerce.addToCart(productA, 2);
        ecommerce.addToCart(serviceB, 1);

        ecommerce.checkout();
    }
}