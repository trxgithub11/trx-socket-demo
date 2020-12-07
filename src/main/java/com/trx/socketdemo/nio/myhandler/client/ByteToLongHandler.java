package com.trx.socketdemo.nio.myhandler.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ByteToLongHandler extends ChannelInboundHandlerAdapter {



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client channelRead is invoked!");
        System.out.println(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception is general");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive  is invoked!");
        ctx.writeAndFlush(1234L);
    }
}
