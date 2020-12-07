package com.trx.socketdemo.nio.firstexample;


import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {

        ch.pipeline().addLast(new HttpServerCodec());
        ch.pipeline().addLast("testHttpSeverHandler",new TestHttpServerHandler());
    }
}
