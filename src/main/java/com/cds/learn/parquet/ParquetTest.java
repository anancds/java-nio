package com.cds.learn.parquet;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.format.converter.ParquetMetadataConverter;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.api.ReadSupport;
import org.apache.parquet.hadoop.example.GroupReadSupport;
import org.apache.parquet.hadoop.metadata.ParquetMetadata;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;

public class ParquetTest {

    private static Configuration conf = new Configuration();

    private static String readParquet() throws URISyntaxException, IOException {

//        FileSystem fs = FileSystem.get(URI.create("hdfs://207.207.77.62:8020"), conf);
                FileSystem fs = FileSystem.get(conf);
//        Path path = new Path("/salut/image/FaceImage/Past/");
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
                    ReadSupport<Group> readSupport = new GroupReadSupport();
                    ParquetReader<SimpleRecord> reader =
                        ParquetReader.builder(new SimpleReadSupport(), files[0].getPath()).build();
                    SimpleRecord value = reader.read();
                    System.out.println("abcdefs:" + value.getValues());



                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        readParquet();

        DB db = DBMaker.memoryDB().make();
        ConcurrentMap map = db.hashMap("map").createOrOpen();
        map.put("a", "b");
        db.close();
    }
}
