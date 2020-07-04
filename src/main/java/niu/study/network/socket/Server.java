package niu.study.network.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        // 退出条件
        final String QUIT = "quit";
        // 服务器端口
        final int PORT = 8080;
        // 服务器的 socket 对象
        ServerSocket serverSocket = null;

        try {
            // 绑定监听端口
            serverSocket = new ServerSocket(PORT);
            System.out.println("启动服务器，监听端口：" + PORT);

            while (true){
                // 等待客户端连接
                Socket socket = serverSocket.accept();
                System.out.println("客户端[" + socket.getPort() + "]已连接");
                // 获取和客户端通信的字符输入流和字符输出流
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                // 读取客户端发送的消息
                String message;
                while ((message = br.readLine()) != null){
                    System.out.println("客户端[" + socket.getPort() + "]发送消息：" + message);

                    // 回复客户端
                    bw.write("服务器已经收到消息：" + message + "\n");
                    bw.flush();

                    // 查看客户端是否关闭
                    if (QUIT.equals(message)){
                        System.out.println("客户端[" + socket.getPort() + "]已断开连接");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if(serverSocket != null){
                try {
                    serverSocket.close();
                    System.out.println("关闭 serverSocket");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
