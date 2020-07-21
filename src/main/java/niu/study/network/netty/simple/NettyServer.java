package niu.study.network.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) {
        //创建BossGroup和WorkerGroup
        /**
         * 1.创建两个线程组bossGroup和workerGroup
         * 2.bossGroup只是处理连接请求，真正和客户端业务处理会交给workerGroup完成
         * 3.两个都是无限循环
         * 4.bossGroup和workerGroup 含有的子线程(NioEventLoop)的个数
         *    默认实际 cpu 处理器数 * 2
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);
        try {
            //创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)//设置两个线程组
                .channel(NioServerSocketChannel.class) //使用NioSocketChannel作为服务器的通道实现
                .option(ChannelOption.SO_BACKLOG, 128)// 对于boss线程组，标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度。
                .childOption(ChannelOption.SO_KEEPALIVE, true)// worker线程组的channel是否启用心跳保活机制。
                .childHandler(new ChannelInitializer<SocketChannel>() {//给worker线程组的EventLoop对应的channel设置handler
                    //给pipeline设置处理器
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
            System.out.println("...服务器 is ready..");
            ChannelFuture cf = bootstrap.bind(6668).sync();//异步地绑定服务器;调用 sync() 方法阻塞等待直到绑定完成,调用的sync()的目的就是保证ChannelFuture已经完成了
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("监听端口 6668成功");
                    } else {
                        System.out.println("监听端口 6668失败");
                    }
                }
            });
            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();//优雅地关闭
            workerGroup.shutdownGracefully();
        }

    }
}
