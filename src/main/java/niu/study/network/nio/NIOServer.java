package niu.study.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //loop wait
        while (true) {
            //没有任何事件发生
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1s， 无连接");
                continue;
            }
            //如果返回的>0 就获取到关注事件的selectionKey集合

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 根据key发生的事件做不同的处理
                if (key.isAcceptable()) { //如果监听到的事件是有一个客户端来连接
                    //accept()不会阻塞，因为监听到了已经，人家就是要连接，此时应当创建一个新的通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector，关注事件为OP_READ,同时给通道关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()) {
                    //通过key反向获取到对应的channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    String hostAddress = channel.socket().getInetAddress().getHostAddress();
                    int port = channel.socket().getPort();
                    System.out.println("from 客户端" + hostAddress +":"+port + new String(buffer.array()));
                }
                //手动从集合中移除当前的selectionKey，防止重复操作
                iterator.remove();
            }
        }
    }
}
