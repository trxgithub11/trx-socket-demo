package com.trx.socketdemo.nio.sencodexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;


public class MyClientHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output:"+ msg);
        ctx.writeAndFlush("from client:"+ LocalDateTime.now());
    }



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("来自客户端的请求!!!");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
