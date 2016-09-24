package com.cds.learn.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

public class DBTest {
    private static void HtreemapTest() {
        DB dbMemory = DBMaker.memoryDB().make();
//        HTreeMap inMemory = dbMemory.hashMap("inMemory").expireMaxSize(1).createOrOpen();
        HTreeMap inMemory = dbMemory.hashMap("inMemory").expireMaxSize(1).create();
        inMemory.put("1", 1);
        inMemory.put("1", 1);
        inMemory.put("1", 1);
        System.out.println(inMemory.size());
        inMemory.put("2", 2);
        inMemory.put("3", 3);
        System.out.println(inMemory.size());
        System.out.println(inMemory.get("2"));
        dbMemory.close();

    }

    public static void main(String[] args) {
        HtreemapTest();

    }
}
