package com.akishor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    private static Map<String, Order> orders = new HashMap<>();
    public static void main(String[] args) {

        Optional<Order> maybeOrder = getOrder("123");

        maybeOrder.ifPresent(order -> System.out.println("Order retrieved " + order.getDescription()));

        if(maybeOrder.isPresent()) {
            System.out.println(maybeOrder.get().getDescription());
        } else {
            System.out.println("No order present");
        }
    }

    private static Optional<Order> getOrder(String orderId){

        return Optional.ofNullable(orders.get(orderId));
    }
}
