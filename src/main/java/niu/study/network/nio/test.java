package niu.study.network.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = new FileInputStream("D:\\STUDY\\JavaProject\\new5\\src\\main\\java\\niu\\study\\network\\nio\\111.txt");
        FileChannel channel1 = fis1.getChannel();
        FileOutputStream fis2 = new FileOutputStream("D:\\STUDY\\JavaProject\\new5\\src\\main\\java\\niu\\study\\network\\nio\\222.txt");
        FileChannel channel2 = fis2.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            // byteBuffer.clear();
            // 从channel到buffer
            int read = channel1.read(byteBuffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            // 从buffer到channel
            channel2.write(byteBuffer);

        }
        fis1.close();
        fis2.close();
    }
}
