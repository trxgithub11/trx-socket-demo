package com.trx.socketdemo.nio.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewClient {

    public static void main(String[] args) throws Exception{

        SocketChannel socketChannel =SocketChannel.open();

        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress("localhost",8080));
        FileChannel fileChannel = new FileInputStream("test.txt").getChannel();
        long startTime = System.currentTimeMillis();

        long transferCount = fileChannel.transferTo(0,fileChannel.size(),socketChannel);

        System.out.println("发送总字节数："+transferCount+",耗时："+(System.currentTimeMillis()-startTime));
        fileChannel.close();
    }
}
