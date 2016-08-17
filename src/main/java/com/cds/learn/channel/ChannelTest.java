package com.cds.learn.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html#
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        FileOutputStream fout = new FileOutputStream( "src/main/resources/writesomebytes.txt" );
        FileChannel fc = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );

        //将数据从channel读到buffer
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                buffer.put(buf.get());
            }
            buffer.flip();
            fc.write(buffer);
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
