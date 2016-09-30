package com.cds.learn.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.util.concurrent.TimeUnit;

public class DBTest {
    private static void HtreemapTest() throws InterruptedException {
        DB dbMemory = DBMaker.memoryDB().make();
//        HTreeMap inMemory = dbMemory.hashMap("inMemory").expireMaxSize(1).createOrOpen();
        HTreeMap inMemory = dbMemory.hashMap("inMemory").expireMaxSize(1).expireAfterGet(1, TimeUnit.MILLISECONDS).create();
        inMemory.put("1", 1);
        System.out.println(inMemory.size());
        inMemory.put("2", 2);
        inMemory.put("3", 3);
        System.out.println(inMemory.size());
        System.out.println(inMemory.get("2"));

        Thread.sleep(1000);
        System.out.println(inMemory.size());
        HTreeMap out = dbMemory.hashMap("inMemory").open();
        System.out.println(out.size());
        dbMemory.close();

    }

    public static void main(String[] args) {
        try {
            HtreemapTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
