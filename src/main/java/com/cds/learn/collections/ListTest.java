/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :java-nio
 * Package Name :com.cds.learn.collections
 * Date Created :2016/9/23
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/9/23      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.learn.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        System.out.println(list.subList(0, 0));
        System.out.println(list.addAll(list2));
        System.out.println(list);
    }
}
