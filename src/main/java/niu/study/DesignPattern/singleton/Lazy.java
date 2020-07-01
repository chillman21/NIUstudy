package niu.study.DesignPattern.singleton;

/**
 * 懒汉式：
 * 延迟创建实例对象
 * 1.构造器私有化
 * 2.用一个静态变量保存这个唯一的实例
 * 3.提供一个静态方法，获取这个实例对象
 */
public class Lazy {
    private volatile static Lazy INSTANCE;
    private Lazy(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    public static Lazy getInstance() {
            if(INSTANCE==null){
            synchronized (Lazy.class) {
                if (INSTANCE == null) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    INSTANCE = new Lazy();//不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向内存空间
                     *
                     * 若为132 此时lazy还没有完成构造，会指向虚无的空间
                     */
                }
            }
        }
        return INSTANCE;
    }
}
