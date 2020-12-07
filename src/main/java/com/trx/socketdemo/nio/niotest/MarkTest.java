package com.trx.socketdemo.nio.niotest;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class MarkTest {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put('你');
        buffer.put('好');
        output("put",buffer);
//  经过标记后，会持续记住此位置
        buffer.position(1).mark();
        output("mark",buffer);
        while(buffer.hasRemaining()) {
            buffer.get();
            System.out.println(buffer.get());
            //  mark将会跳转到上次标记的位置
            buffer.reset();
//            output("reset",buffer);
        }
    }

    public static void output(String step, CharBuffer buffer) {
        System.out.println(step + " : ");
        //容量，数组大小
        System.out.print("capacity: " + buffer.capacity() + ", ");
        //当前操作数据所在的位置，也可以叫做游标
        System.out.print("position: " + buffer.position() + ", ");
        //锁定值，flip，数据操作范围索引只能在position - limit 之间
        System.out.println("limit: " + buffer.limit());
//        System.out.println("mark: " + buffer.mark());
        System.out.println();
    }
}
