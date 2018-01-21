package pnodder.model;

import java.util.HashSet;
import java.util.Set;

public class Basket {

    private Set<OrderItem> items;

    public Basket() {
        items = new HashSet<OrderItem>();
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public void addToBasket(OrderItem item) {
        items.add(item);
    }
}
