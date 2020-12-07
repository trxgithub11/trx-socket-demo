package com.trx.socketdemo.nio.niotest;


import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChanneltest1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] message = "hello world welcome!".getBytes();
        for (int i = 0; i <message.length ; i++) {
            byteBuffer.put(message[i]);
        }

        output("",byteBuffer);
        byteBuffer.flip();
        output("",byteBuffer);
        fileChannel.write(byteBuffer);
        output("",byteBuffer);
        fileOutputStream.close();


//        int[] sss = new int[10];
//        sss[0]=1;
//        sss[1]=2;
//        sss[2]=3;
//        sss[3]=4;
//
//        for (int i = 0; i <4 ; i++) {
//            System.out.println(sss[i]);
//        }
    }

    public static void output(String step, ByteBuffer buffer) {
        System.out.println(step + " : ");
        //容量，数组大小
        System.out.print("capacity: " + buffer.capacity() + ", ");
        //当前操作数据所在的位置，也可以叫做游标
        System.out.print("position: " + buffer.position() + ", ");
        //锁定值，flip，数据操作范围索引只能在position - limit 之间
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }
}
