import cart.CartItem;
import itens.Item;
import itens.Product;
import cart.ShoppingCart;
import org.example.payment.PaymentProvider;

public class ECommerce {
    private final PaymentProvider paymentProvider;
    private final ShoppingCart shoppingCart;

    public ECommerce(PaymentProvider paymentProvider, ShoppingCart shoppingCart) {
        this.paymentProvider = paymentProvider;
        this.shoppingCart = shoppingCart;
    }

    public void addToCart(Item item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        shoppingCart.addItem(cartItem);
        System.out.println(quantity + " " + item.getName() + "(s) added to the shopping cart.");
    }

    public void checkout() {
        double totalAmount = shoppingCart.calculateTotal();
        System.out.println("Total amount in the shopping cart: " + totalAmount);
        paymentProvider.processPayment(totalAmount);
        // Lógica adicional de checkout, como limpar o carrinho, enviar confirmação, etc.
        shoppingCart.getCartItems().clear();
    }
}