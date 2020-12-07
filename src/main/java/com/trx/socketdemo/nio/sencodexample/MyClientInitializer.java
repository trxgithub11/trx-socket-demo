package com.trx.socketdemo.nio.sencodexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class MyClientInitializer  extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
        p.addLast(new LengthFieldPrepender(4));



        p.addLast(new StringDecoder(CharsetUtil.UTF_8));
        p.addLast(new StringEncoder(CharsetUtil.UTF_8));
        p.addLast("myserverhandler",new MyClientHandler());
    }
}
