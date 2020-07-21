package niu.study.network.netty.simple;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * 我们自定义一个handler，需要继承netty 规定好的某个HandlerAdapter适配器
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    //读取数据的事件

    /**
     *
     * @param ctx ChannelHandlerContext:上下文对象，含有管道pipeline，通道channel，地址
     * @param msg 就是客户端发送的数据，默认Object
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("服务器读取线程 " + Thread.currentThread().getName());
//        System.out.println("server ChannelHandlerContext = " + ctx);
//        System.out.println("channel和pipeline的关系：");
//        Channel channel = ctx.channel();
//        ChannelPipeline pipeline = ctx.pipeline();//本质是一个双向链表
//        //将msg转成一个ByteBuf
//        //ByteBuf是netty提供的，不是NIO的ByteBuffer，ByteBuf性能更高
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("客户端发送的消息是" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
        //耗时业务 -> 异步执行->提交到该channel对应的 NIOEventLoop 的 taskQueue 中

        //解决方案1 用户程序自定义的普通任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端(>^ω^<)喵1", CharsetUtil.UTF_8));
                    System.out.println("go on .. ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //解决方案2 用户自定义定时任务 -> 该任务是提交到scheduleTaskQueue中
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端(>^ω^<)喵2", CharsetUtil.UTF_8));
                    System.out.println("go on .. ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },5, TimeUnit.SECONDS);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写到buffer，并刷新
        //一般来讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端(>^ω^<)喵", CharsetUtil.UTF_8));
    }
    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
