package niu.study.jvm;

public class Demo01 {
    public static void main(String[] args) {
        //返回虚拟机试图使用的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回jvm初始化总内存
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.gc();//GC的作用区：方法区、堆
        //执行System.gc()函数的作用只是提醒或告诉虚拟机，希望进行一次垃圾回收。
        //至于什么时候进行回收还是取决于虚拟机，
        // 而且也不能保证一定进行回收
        // （如果-XX:+DisableExplicitGC设置成true，则不会进行回收）。
    }
}
