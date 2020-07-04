package niu.study.network.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // 退出条件
        final String QUIT = "quit";
        // 服务器主机和端口
        final String HOST = "127.0.0.1";
        final int PORT = 8080;
        // 客户端的 socket 对象
        Socket socket = null;
        BufferedWriter bw = null;

        try {
            // 创建 socket
            socket = new Socket(HOST, PORT);

            // 获取和服务器通信的字符输入流和字符输出流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 等待用户输入信息
            while (true) {
                System.out.println("请输入要发送的消息：");
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                String input = consoleReader.readLine();

                // 发送消息给服务器
                bw.write(input + "\n");
                bw.flush();

                // 读取服务器返回的消息
                String message= br.readLine();
                if (message != null) {
                    System.out.println("服务器发送消息：" + message);
                }

                // 查看用户是否退出
                if(QUIT.equals(input)){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放资源
            try {
                if(bw != null) {
                    bw.close();
                    System.out.println("关闭 socket");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
