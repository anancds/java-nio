package com.cds.learn.parquet;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.format.converter.ParquetMetadataConverter;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetRecordReader;
import org.apache.parquet.hadoop.api.ReadSupport;
import org.apache.parquet.hadoop.example.GroupReadSupport;
import org.apache.parquet.hadoop.metadata.ParquetMetadata;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.apache.parquet.example.data.simple.SimpleGroup;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class ParquetTest {

    private static Configuration conf = new Configuration();

    private static String loadData(String business, int dimNums) {
//        switch (business) {
//            case "dulSnapID FaceImage":
//                break;
//
//        }
        return "";
    }

    private static String readParquet() throws URISyntaxException, IOException {

//                FileSystem fs = FileSystem.get(URI.create("hdfs://207.207.77.62:8020"), conf);
        FileSystem fs = FileSystem.get(conf);
//                Path path = new Path("/salut/image/");
        Path path = new Path("/salut");

        FileStatus[] years = fs.listStatus(path);
        System.out.println(Arrays.toString(years));
        for (FileStatus year : years) {
            FileStatus[] months = fs.listStatus(year.getPath());
            for (FileStatus month : months) {
                FileStatus[] days = fs.listStatus(month.getPath());
                for (FileStatus day : days) {

                    FileStatus[] files = fs.listStatus(day.getPath());
                    ParquetMetadata readFooter = ParquetFileReader
                        .readFooter(conf, files[0].getPath(), ParquetMetadataConverter.NO_FILTER);
                    System.out.println(readFooter.getFileMetaData().getSchema());
//                    ReadSupport<Group> readSupport = new GroupReadSupport();
//                    ParquetReader<SimpleRecord> reader =
//                        ParquetReader.builder(new SimpleReadSupport(), files[0].getPath()).build();
//                    int num = 1;
//                    PrintWriter writer = new PrintWriter(System.out, true);
//                    for (SimpleRecord value = reader.read(); value != null && num-- > 0; value = reader.read()) {
//                        System.out.println(value.getValues().get(0));
//                    }
//                    for (int i = 0; i < value.getValues().size(); i ++) {
//                        System.out.println(value.getValues().get(0).getValue());
//                    }
//                    System.out.println("abcdefs:" + value.getValues());

                    ReadSupport<Group> readSupport = new GroupReadSupport();
                    ParquetReader<Group> reader1 =
                        ParquetReader.builder(readSupport, files[0].getPath()).build();
                    Group group = reader1.read();
                    System.out.println(group.getGroup("features", 0).getGroup("bag", 0).getDouble("array", 0));
                    for (int i = 0; i < 180; i++) {
                        System.out.println(group.getGroup("features", 0).getGroup("bag", i).getDouble("array", 0));
                    }

                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
                readParquet();

//        DB db = DBMaker.fileDB("/abc").make();
//        ConcurrentMap map = db.hashMap("map").createOrOpen();
//        System.out.println(map.get("a"));
//        map.put("a", "b");
//        for (int i = 0; i < 1000; i++) {
//            map.put(i, i);
//        }
//        db.commit();
//        System.out.println(map.get("a"));
//        db.close();
    }
}
