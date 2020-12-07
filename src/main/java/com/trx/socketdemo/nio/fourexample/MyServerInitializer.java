package com.trx.socketdemo.nio.fourexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
//websocket handler
public class MyServerInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        //
        pipeline.addLast(new HttpObjectAggregator(8192));
        //ws://server:port/context_path   ws://localhsot:8080/ws
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new MyServerHandler());
    }
}
