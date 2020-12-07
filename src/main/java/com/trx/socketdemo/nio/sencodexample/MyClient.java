package com.trx.socketdemo.nio.sencodexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


public class MyClient {

    public static void main(String[] args) {
        EventLoopGroup  bossgroup = new NioEventLoopGroup();
        Bootstrap  client = new Bootstrap();

        try{
            client.group(bossgroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());
            ChannelFuture f = client.connect("localhost",8080).sync();

            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossgroup.shutdownGracefully();
        }

    }

}
