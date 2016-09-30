/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :java-nio
 * Package Name :com.cds.learn.guava
 * Date Created :2016/9/24
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/9/24      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.learn.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class CacheTest {

    public static void main(String[] args) throws ExecutionException {

        Map<String, Long> map = new HashMap<>();
        map.put("a", 1L);
        map.put("b", 2L);
        map.put("c", 3L);
        LoadingCache<String, Long> cahceBuilder = CacheBuilder.newBuilder().maximumSize(1000).build(new CacheLoader<String, Long>() {
            @Override
            public Long load(String key) throws Exception {
                return 1L;
            }
        });

        System.out.println(cahceBuilder.get("a"));
        System.out.println(cahceBuilder.get("b"));
        System.out.println(cahceBuilder.asMap());
        System.out.println(cahceBuilder.get("a"));
        System.out.println(cahceBuilder.asMap());
//        System.out.println(cahceBuilder.get("b"));
//        System.out.println(cahceBuilder.get("c"));

    }
}
