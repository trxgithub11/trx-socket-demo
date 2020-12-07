package com.trx.socketdemo.nio.niotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChanneltest {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("test1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.println((char) b);

        }

        fileInputStream.close();
    }
}
