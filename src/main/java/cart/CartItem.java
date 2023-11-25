package cart;

import itens.Item;

public class CartItem {
    private Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return quantity * item.getPrice();
    }

    @Override
    public String toString() {
        return "{" +
                "item=" + item.getName() +
                ", quantity=" + quantity +
                '}';
    }
}