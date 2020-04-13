package com.akishor;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {

        //BlockingQueue<String> dataItems = new ArrayBlockingQueue<String>(10);
        MyBlockingQueue<String> dataItems = new MyBlockingQueue<>(10);

        Thread producer = new Thread(() -> {
            for(int i=0; i<10; i++) {

                try {
                    dataItems.put("item"+i);
                    System.out.println("Item produced "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread consumer = new Thread(() -> {
            for(int i=0; i<10; i++) {
                try {
                    String item = dataItems.take();
                    System.out.println("Item consumed "+i);
                    System.out.println("Consumed Item "+item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();
        producer.start();
    }

    public static class MyBlockingQueue<T> {

        private LinkedList<T> queue;
        private int max_size;
        private Object lock = new Object();

        public MyBlockingQueue(int size) {
            queue = new LinkedList<>();
            this.max_size = size;
        }

        public synchronized T take() throws InterruptedException {
            while(queue.size() == 0){
                this.wait();
            }

            T element = queue.remove();
            this.notifyAll();
            return element;
        }

        public synchronized void put(T element) throws InterruptedException {
            while (queue.size() == max_size){
                this.wait();
            }
            queue.add(element);
            this.notifyAll();
        }

    }

}
