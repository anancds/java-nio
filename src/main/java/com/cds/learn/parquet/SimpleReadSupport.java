package com.cds.learn.parquet;

import java.util.Map;

import org.apache.hadoop.conf.Configuration;

import org.apache.parquet.hadoop.api.InitContext;
import org.apache.parquet.hadoop.api.ReadSupport;
import org.apache.parquet.io.api.RecordMaterializer;
import org.apache.parquet.schema.MessageType;

public class SimpleReadSupport extends ReadSupport<SimpleRecord> {
    @Override
    public RecordMaterializer<SimpleRecord> prepareForRead(Configuration conf, Map<String,String> metaData, MessageType schema, ReadContext context) {
        return new SimpleRecordMaterializer(schema);
    }

    @Override
    public ReadContext init(InitContext context) {
        return new ReadContext(context.getFileSchema());
    }
}
