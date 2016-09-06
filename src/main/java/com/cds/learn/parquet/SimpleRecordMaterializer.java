package com.cds.learn.parquet;

import org.apache.parquet.io.api.GroupConverter;
import org.apache.parquet.io.api.RecordMaterializer;
import org.apache.parquet.schema.MessageType;

public class SimpleRecordMaterializer extends RecordMaterializer<SimpleRecord> {
    public final SimpleRecordConverter root;

    public SimpleRecordMaterializer(MessageType schema) {
        this.root = new SimpleRecordConverter(schema);
    }

    @Override
    public SimpleRecord getCurrentRecord() {
        return root.getCurrentRecord();
    }

    @Override
    public GroupConverter getRootConverter() {
        return root;
    }
}

