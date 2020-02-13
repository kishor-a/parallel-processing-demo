package com.akishor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OrderHandler {

    private Order placeAnOrder(){

        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .description("Product prize is "+Math.random())
                .build();
        System.out.println("Order placed order id "+order.getOrderId());
        return order;
    }

    private Order makePayment(Order order){

        order.setPaymentDone(true);
        System.out.println("Payment done for order "+order.getOrderId());
        return order;
    }

    private Order dispatch(Order order){

        order.setDispatch(true);
        System.out.println("Order dispatched "+order.getOrderId());
        return order;
    }

    private Order sendMail(Order order){
        order.setMailSent(true);
        System.out.println("Confirmation mail send for order "+order.getOrderId());
        return order;
    }

    public void handleOrder() throws ExecutionException, InterruptedException {

        List<CompletableFuture> completableFutureList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            CompletableFuture futureOrder = CompletableFuture.supplyAsync(this::placeAnOrder)
                    .thenApply(this::makePayment)
                    .thenApply(this::dispatch)
                    .thenApply(this::sendMail);
            completableFutureList.add(futureOrder);
        }


    }

    public static void main(String[] args) {
        OrderHandler orderHandler=new OrderHandler();

    }
}
