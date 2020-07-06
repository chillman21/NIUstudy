package niu.study.network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

/**
 * 传统BIO
 */
public class TimeServerHandler implements Runnable {
    private Socket clientProxy;

    public TimeServerHandler(Socket clientProxy) {
        this.clientProxy = clientProxy;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(clientProxy.getInputStream()));
            writer =new PrintWriter(clientProxy.getOutputStream()) ;
            while (true) {//因为一个client可以发送多次请求，这里的每一次循环，相当于接收处理一次请求
                String request = reader.readLine();
                if (!"GET CURRENT TIME".equals(request)) {
                    writer.println("BAD_REQUEST");
                } else {
                    writer.println(Calendar.getInstance().getTime().toLocaleString());
                }
                writer.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
                reader.close();
                clientProxy.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}