package com.trx.socketdemo.nio.rpc.consumer.proxy;

import com.trx.socketdemo.nio.myhandler.client.ByteToLongHandler;
import com.trx.socketdemo.nio.nettyencodeordecode.MyBytetoLongDecoder;
import com.trx.socketdemo.nio.rpc.protocol.InvokerProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxy {

    public  static <T> T create(Class<T> clazz){

        MethodProxy proxy = new MethodProxy(clazz);
        Class<?>[]  interfaces = clazz.isInterface()? new Class[]{clazz}:clazz.getInterfaces();
        T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(),interfaces,proxy);
        return result;
    }

    private static class MethodProxy implements InvocationHandler{

        private  Class<?>  clazz;
        public  MethodProxy(Class<?> clazz){this.clazz=clazz;}


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           if(Object.class.equals(method.getDeclaringClass())){

               try{
                   return method.invoke(this,args);
               }catch(Exception e){

                   e.printStackTrace();
               }
           }else{
               return rpcInvoke(proxy,method,args);
           }

            return null;
        }

        public Object rpcInvoke(Object proxy,Method method,Object[] args){

            InvokerProtocol msg = new InvokerProtocol();
            msg.setClassName(this.clazz.getName());
            msg.setMethodName(method.getName());
            msg.setValues(args);
            msg.setParams(method.getParameterTypes());
            final RpcProxyHandler consumerHandler = new RpcProxyHandler();
            EventLoopGroup group = new NioEventLoopGroup();
            try{
                Bootstrap b = new Bootstrap();

                b.group(group)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY,true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel client) throws Exception {

                                client.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                                client.pipeline().addLast("frameEncoder",new LengthFieldPrepender(4));
                                client.pipeline().addLast("encoder",new ObjectEncoder());
                                client.pipeline().addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                                client.pipeline().addLast("handler",consumerHandler);
                                client.pipeline().addLast(new MyBytetoLongDecoder());
                                client.pipeline().addLast(new ByteToLongHandler());
                            }
                        });
                ChannelFuture future = b.connect("localhost",8080).sync();
                future.channel().writeAndFlush(msg).sync();
                future.channel().closeFuture().sync();
            }catch (Exception e){

                e.printStackTrace();
            }finally{
                group.shutdownGracefully();
            }

            return consumerHandler.getResponse();
        }
    }
}
