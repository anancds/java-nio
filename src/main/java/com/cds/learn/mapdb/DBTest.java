package com.cds.learn.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

public class DBTest {
    private static void HtreemapTest() {
        DB dbMemory = DBMaker.memoryDB().make();
        HTreeMap inMemory = dbMemory.hashMap("inMemory").expireMaxSize(1).createOrOpen();
        System.out.println(inMemory.size());

    }

    public static void main(String[] args) {
        HtreemapTest();

    }
}
