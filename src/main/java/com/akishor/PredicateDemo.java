package com.akishor;

import java.util.function.Predicate;

public class PredicateDemo {

    private static Predicate<Order> completed = (order ->
            order.isPaymentDone() && order.isDispatch() && order.isMailSent());

    public static void main(String[] args) {
        Order order = Order.builder().orderId("o12345").dispatch(true).paymentDone(true).mailSent(true).build();
        if(completed.test(order)){
            System.out.println("Order completed "+order.getOrderId());
        }
    }


}
