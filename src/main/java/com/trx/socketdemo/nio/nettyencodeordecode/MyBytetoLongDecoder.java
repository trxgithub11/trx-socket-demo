package com.trx.socketdemo.nio.nettyencodeordecode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyBytetoLongDecoder extends ReplayingDecoder<Void > {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("MyBytetoLongDecoder is  invoked!");
        out.add(in.readLong());

    }
}
