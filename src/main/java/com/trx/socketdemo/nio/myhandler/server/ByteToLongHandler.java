package com.trx.socketdemo.nio.myhandler.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ByteToLongHandler extends ChannelInboundHandlerAdapter {



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead  is invoked!");
        System.out.println(msg);
        ctx.writeAndFlush(5678L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception is general");
    }


}
