package cart;

import java.util.List;

public class CheckoutInfo {
    private List<CartItem> cartItems;
    private double totalAmount;

    public CheckoutInfo(List<CartItem> cartItems, double totalAmount) {
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getTotalAmount() {
        return "Valor total: " + totalAmount;
    }
}