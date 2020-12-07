package com.trx.socketdemo.nio.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup  bossgroup = new NioEventLoopGroup();
        EventLoopGroup  workgroup = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossgroup, workgroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());

            ChannelFuture f = server.bind(8080).sync();
            f.channel().closeFuture().sync();
        }finally {
            bossgroup.shutdownGracefully();
            workgroup.shutdownGracefully();
        }

    }
}
