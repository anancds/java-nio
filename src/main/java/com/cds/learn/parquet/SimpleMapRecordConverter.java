/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :java-nio
 * Package Name :com.cds.learn.parquet
 * Date Created :2016/9/6
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/9/6      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.learn.parquet;

import org.apache.parquet.schema.GroupType;

public class SimpleMapRecordConverter extends SimpleRecordConverter {

    public SimpleMapRecordConverter(GroupType schema, String name, SimpleRecordConverter parent) {
        super(schema, name, parent);
    }

    @Override
    public void start() {
        record = new SimpleMapRecord();
    }

}
