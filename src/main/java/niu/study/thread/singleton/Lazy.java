package niu.study.thread.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 懒汉式单例
 */
public class Lazy {
    private static boolean niuge = false;
    private Lazy(){
//        synchronized (Lazy.class){
//            if (niuge == false){
//                niuge = true;
//            } else{
//                throw new RuntimeException("不要试图使用反射破坏异常");
//            }
//        }
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private volatile static Lazy lazy;
    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static Lazy getInstance(){
        if (lazy==null){
            synchronized (Lazy.class){
                if (lazy == null){
                    lazy = new Lazy();//不是一个原子性操作
                    /**
                     * 为什么这是一个非原子性操作？
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     * 期望执行顺序：123
                     * 由于指令重排序，有可能：132
                     * eg： A刚执行完13
                     *     B此时开始执行，发现lazy不为null 会return一个未完成构造的lazy对象。
                     */
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args) throws Exception {
        Field niuge = Lazy.class.getDeclaredField("niuge");
        niuge.setAccessible(true);
        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Lazy lazy = declaredConstructor.newInstance();
        niuge.set(lazy,false);
        Lazy lazy1 = declaredConstructor.newInstance();
        System.out.println(lazy);
        System.out.println(lazy1);
    }

    //单线程下懒汉单例确实ok
    //多线程并发
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                Lazy.getInstance();
//            }).start();
//        }
//    }
}
