package com.akishor;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class OrderHandlerTest {

    @Test
    public void handleOrder() throws ExecutionException, InterruptedException {
        OrderHandler orderHandler = new OrderHandler();

        orderHandler.handleOrder();
    }

}