package com.trx.socketdemo.nio.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInitializer  extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //心跳handler
        pipeline.addLast(new IdleStateHandler(6,7,10, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
