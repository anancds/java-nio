package com.cds.learn.parquet;


import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.parquet.io.api.Binary;
import org.apache.parquet.io.api.Converter;
import org.apache.parquet.io.api.GroupConverter;
import org.apache.parquet.io.api.PrimitiveConverter;
import org.apache.parquet.schema.GroupType;
import org.apache.parquet.schema.OriginalType;
import org.apache.parquet.schema.Type;

/**
 *
 *
 * @author
 */
public class SimpleRecordConverter extends GroupConverter {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final CharsetDecoder UTF8_DECODER = UTF8.newDecoder();

    private final Converter converters[];
    private final String name;
    private final SimpleRecordConverter parent;
    protected SimpleRecord record;

    public SimpleRecordConverter(GroupType schema) {
        this(schema, null, null);
    }

    public SimpleRecordConverter(GroupType schema, String name, SimpleRecordConverter parent) {
        this.converters = new Converter[schema.getFieldCount()];
        this.parent = parent;
        this.name = name;

        int i = 0;
        for (Type field: schema.getFields()) {
            converters[i++] = createConverter(field);
        }
    }

    private Converter createConverter(Type field) {
        OriginalType otype = field.getOriginalType();

        if (field.isPrimitive()) {
            if (otype != null) {
                switch (otype) {
                    case MAP: break;
                    case LIST: break;
                    case UTF8: return new StringConverter(field.getName());
                    case MAP_KEY_VALUE: break;
                    case ENUM: break;
                }
            }

            return new SimplePrimitiveConverter(field.getName());
        }

        GroupType groupType = field.asGroupType();
        if (otype != null) {
            switch (otype) {
                case MAP: return new SimpleMapRecordConverter(groupType, field.getName(), this);
                case LIST: return new SimpleListRecordConverter(groupType, field.getName(), this);
            }
        }
        return new SimpleRecordConverter(groupType, field.getName(), this);
    }

    @Override
    public Converter getConverter(int fieldIndex) {
        return converters[fieldIndex];
    }

    SimpleRecord getCurrentRecord() {
        return record;
    }

    @Override
    public void start() {
        record = new SimpleRecord();
    }

    @Override
    public void end() {
        if (parent != null) {
            parent.getCurrentRecord().add(name, record);
        }
    }

    private class SimplePrimitiveConverter extends PrimitiveConverter {
        protected final String name;

        public SimplePrimitiveConverter(String name) {
            this.name = name;
        }

        @Override
        public void addBinary(Binary value) {
            record.add(name, value.getBytes());
        }

        @Override
        public void addBoolean(boolean value) {
            record.add(name, value);
        }

        @Override
        public void addDouble(double value) {
            record.add(name, value);
        }

        @Override
        public void addFloat(float value) {
            record.add(name, value);
        }

        @Override
        public void addInt(int value) {
            record.add(name, value);
        }

        @Override
        public void addLong(long value) {
            record.add(name, value);
        }
    }

    private class StringConverter extends SimplePrimitiveConverter {
        public StringConverter(String name) {
            super(name);
        }

        @Override
        public void addBinary(Binary value) {
            record.add(name, value.toStringUsingUTF8());
        }
    }
}
