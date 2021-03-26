package com.java.learn.design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker class.
 */
public class Broker {
    private List<Order> orders;

    public Broker() {
        this.orders = new ArrayList<Order>();
    }

    public void takeOrder(Order order) {
        this.orders.add(order);
    }

    public void placeOrders() {
        for(Order order : this.orders) {
            order.execute();
        }
        this.orders.clear();
    }
}
