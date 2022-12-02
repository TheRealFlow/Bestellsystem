package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class OrderRepo {
    private final Map<String, Order> orders = new HashMap<>();

    public List<Order> listOrders() {
        return List.copyOf(orders.values());
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public Order addOrder(Order newOrder){
        orders.put(newOrder.getId(), newOrder);
        return newOrder;
    }
}
