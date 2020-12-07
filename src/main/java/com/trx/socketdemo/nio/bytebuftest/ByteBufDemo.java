package com.trx.socketdemo.nio.bytebuftest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufDemo {

    public static void main(String[] args) {
        //Pooled  数据存在池中
        ByteBuf  buffer = Unpooled.buffer(10);
        for (int i = 0; i <10 ; i++) {

            buffer.writeByte(i);
        }
        for (int i = 0; i <buffer.capacity() ; i++) {
            System.out.println(buffer.getByte(i));
        }
        for (int i = 0; i <buffer.capacity() ; i++) {
            System.out.println(buffer.readByte());
        }
    }
}
