package com.akishor;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderHandlerTest {

    @Test
    public void handleOrder(){
        OrderHandler orderHandler = new OrderHandler();

        orderHandler.handleOrder();
    }

}