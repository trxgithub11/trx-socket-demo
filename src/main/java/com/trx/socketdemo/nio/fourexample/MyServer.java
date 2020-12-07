package com.trx.socketdemo.nio.fourexample;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        EventLoopGroup  workgroup = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossgroup, workgroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new MyServerInitializer());

            ChannelFuture f = server.bind(8080).sync();
            f.channel().closeFuture().sync();
        }finally {
            bossgroup.shutdownGracefully();
            workgroup.shutdownGracefully();
        }

    }
}
