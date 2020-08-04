package niu.study.thread.interview;

/**
 * 两个线程交替打印A-Z（无锁版）
 * @author NIU
 * @createTime 2020/7/28 16:51
 */
public class AlternatePrint2 {
    static volatile boolean flag = true;
    static volatile char print = 'a';
    public static void main(String[] args) {
        new Thread(() -> {
            while (print <= 'z') {
                if(flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (print <= 'z') {
                if(!flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = true;
                }
            }
        }).start();
    }

}
