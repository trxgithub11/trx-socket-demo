package com.trx.socketdemo.nio.rpc.registry;

import com.sun.xml.internal.bind.api.ClassResolver;
import com.trx.socketdemo.nio.myhandler.server.ByteToLongHandler;
import com.trx.socketdemo.nio.nettyencodeordecode.MyBytetoLongDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;



import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class RpcRegistry {

    private int port;
    public RpcRegistry(int port){
        this.port = port;
    }

    public void start(){

        EventLoopGroup bossgroup = new NioEventLoopGroup();
        EventLoopGroup workgroup = new NioEventLoopGroup();
        try{

            ServerBootstrap server = new ServerBootstrap();
            server.group(bossgroup,workgroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel client) throws Exception {
                            client.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                            client.pipeline().addLast(new LengthFieldPrepender(4));
                            client.pipeline().addLast("encoder",new ObjectEncoder());
                            client.pipeline().addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            client.pipeline().addLast(new RegistryHandler());
                            client.pipeline().addLast(new MyBytetoLongDecoder());
                            client.pipeline().addLast(new ByteToLongHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture future =server.bind(port).sync();
            System.out.println("服务启动....");
            future.channel().closeFuture().sync();

        }catch (Exception e){

            bossgroup.shutdownGracefully();
            workgroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new RpcRegistry(8080).start();
    }
}
