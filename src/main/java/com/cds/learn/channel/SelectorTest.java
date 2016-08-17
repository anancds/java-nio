package com.cds.learn.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class SelectorTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        Selector selector = Selector.open();


    }
}
