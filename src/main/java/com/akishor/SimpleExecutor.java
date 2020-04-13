package com.akishor;

import java.util.concurrent.*;

import static java.lang.System.out;

public class SimpleExecutor {

    private void start(){

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 1. Runnable lambda
        executor.submit( () ->
                out.println("This is from runnable, will run in future") );

        // 2. Callable lambda
        Future<String> helloSayingTask = sayHelloInFuture(executor);

        try {
            String futureResult = helloSayingTask.get();
            out.println(futureResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Future<String> sayHelloInFuture(ExecutorService executor) {
        return executor.submit( () -> {
                out.println("This is callable which will say Hello in future");
                return "Hello";
            } );
    }
}
