package com.example.tests;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Test {

    private static final int QUEUE_CAPACITY = 10;

    public static void main(String[] args) {
        // Create a semaphore with a permit count of 2
        Semaphore semaphore = new Semaphore(2);

        // Create an array of threads
        Thread[] threads = new Thread[5];

        // Create and start the threads
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                try {
                    // Acquire a permit from the semaphore, blocking if necessary
                    semaphore.acquire();
                    System.out.println("Thread " + Thread.currentThread().getId() + " acquired a permit");
                    System.out.println(finalI);
                    Thread.sleep(1000);
                    // Release the permit back to the semaphore
                    semaphore.release();
                    System.out.println("Thread " + Thread.currentThread().getId() + " released a permit");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
    }
}
