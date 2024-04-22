package com.example.pizzasystemv001;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private static int nextOrderNumber = 1;
    private int orderNumber;
    private static List<Order> orders = new ArrayList<>();
    private Pizza pizza;
    private Drinks drink;
    public Order() {
        this.orderNumber = nextOrderNumber++;
        orders.add(this);
    }
    public int getOrderId() {
        return orderNumber;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public Drinks getDrink() {
        return this.drink;
    }
    public static List<Order> getOrders() {
        return orders;
    }


}
