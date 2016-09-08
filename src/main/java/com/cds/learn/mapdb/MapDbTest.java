package com.cds.learn.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("unchecked") public class MapDbTest {

    private static void helloWorld() {



        DB db = DBMaker.memoryDB().fileMmapEnable().checksumHeaderBypass().make();
        ConcurrentMap<Long, float[]> map =
            db.hashMap("map", Serializer.LONG, Serializer.JAVA).createOrOpen();
        System.out.println("begin!!!!");

        System.out.println(System.currentTimeMillis());

        Arrays.sort(map.keySet().toArray());
        System.out.println(System.currentTimeMillis());



        for (long i = 10000L; i < 300000L; i++) {
            float[] list = new float[180];
            for (int j = 0; j < 180; j++) {
                list[j] = 0.54445f;
            }
            map.put(i, list);
        }
        System.out.println("done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(map.size());
        db.close();

        System.exit(0);
    }

    public static void main(String[] args) {


//        new Thread(new Runnable() {
//            @Override public void run() {
//                while (true) {
//
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("max: " + Runtime.getRuntime().totalMemory() / (1024 * 1024));
//                    System.out.println("free: " + Runtime.getRuntime().freeMemory() / (1024 * 1024));
//                }
//            }
//        }).start();

        helloWorld();



    }
}
