package com.cds.learn;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<Float, Long> map = new ConcurrentHashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        long t1 = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50_0000; i++) {
                    map.put(random.nextFloat(), random.nextLong());
                }
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.DAYS);
        System.out.println((System.currentTimeMillis() - t1));
    }
}
