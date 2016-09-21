/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :java-nio
 * Package Name :com.cds.learn.bigdecimal
 * Date Created :2016/9/21
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/9/21      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.learn.bigdecimal;

import java.math.BigDecimal;
import java.util.Random;

public class BigDecimalTest {

    public static void main(String[] args) {

        String prefix = "0.00000000";
        Random random = new Random();
        float cos = 0.71064883f;
        BigDecimal f = new BigDecimal(Float.toString(cos));
        float test = random.nextFloat();
        double d = test / 100_0000_0000.0;

        long ll = random.nextLong();
        System.out.println(ll);
        String last = prefix + ll;
        BigDecimal dd = new BigDecimal(last);
        BigDecimal distance = f.add(dd);
        System.out.println(distance);
    }
}
