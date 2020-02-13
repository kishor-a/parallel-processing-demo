package com.akishor;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class SimpleExecutorTest {

    @Test
    public void futureHelloTest() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        Future<String> result = simpleExecutor.sayHelloInFuture(executor);

        assertEquals("Hello",result.get());
    }

}