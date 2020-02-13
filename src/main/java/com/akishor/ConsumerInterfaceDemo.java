package com.akishor;

import java.util.function.Consumer;

public class ConsumerInterfaceDemo {

    private static Consumer<String> consumeMessage = (message) -> {
        System.out.println(message +" message consumed");
    };

    private static Consumer<String> prettyMessage = (message) -> {
        System.out.println(message.toUpperCase());
    };

    public static void main(String[] args) {
        consumeMessage.andThen(prettyMessage).accept("Hello");
    }
}
