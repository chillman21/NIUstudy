package niu.study.network.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class  TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器
        //得到管道
        ChannelPipeline pipeline = ch.pipeline();
        //HttpServerCodec是一个netty提供的编解码器
        pipeline.addLast("MyHttpSeverCodec", new HttpServerCodec());
        pipeline.addLast("MyHttpServerHandler", new TestHttpServerHandler());
        System.out.println();
    }
}
