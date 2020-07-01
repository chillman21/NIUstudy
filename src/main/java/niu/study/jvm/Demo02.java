package niu.study.jvm;

import java.util.ArrayList;

public class Demo02 {
    //-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError 发生OOM错误时Dump出堆信息
    // -XX:+PrintGCDetails 打印每次GC垃圾回收信息
    //-XX:+HeapDumpOn******* dump其他错误/异常下的堆信息
    //-Xms 初始化内存默认分配大小，默认值为系统内存 1/64
    //-Xmx 设置分配内存，默认为系统内存的1/4
    //错误信息：
    /**
     * java.lang.OutOfMemoryError: Java heap space
     * Dumping heap to java_pid7736.hprof ...
     * Heap dump file created [5025846 bytes in 0.069 secs]
     *  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	    at niu.servlet.jvm.Demo01.<init>(Demo01.java:8)
     * 	    at niu.servlet.jvm.Demo01.main(Demo01.java:15)
     */
    byte[] array = new byte[1024 * 1024];//1m

    public static void main(String[] args) {
        ArrayList<Demo02> list = new ArrayList<>();
        int count = 0;
        try {
            while (true){
                list.add(new Demo02());
                count ++;
            }
        } catch (Error e) {//Exception抓不到，Error可以
            System.out.println("count:"+count);
            e.printStackTrace();
        }

    }
}
