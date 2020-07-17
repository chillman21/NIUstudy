package niu.study.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        //连接成功
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他操作");
            }
        }
        // 连接失败
        String str = "nice to meet you";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        //发送数据，将buffer数据写入channel
        socketChannel.write(buffer);
        System.in.read();
    }
}
