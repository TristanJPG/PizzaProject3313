package com.example.pizzasystemv001;

import java.util.HashMap;
import java.util.List;

public class Purchase {
    private static HashMap<Integer, Order> orders = new HashMap<>();;


    public static void addOrder(List<Order> orderList) {
        for (Order order : orderList) {
            orders.put(order.getOrderId(), order);
        }
    }

    public static Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public void removeOrder(int orderId) {
        orders.remove(orderId);
    }

    public void updateOrder(int orderId, Order newOrder) {
        if (orders.containsKey(orderId)) {
            orders.put(orderId, newOrder);
        }
    }
}
