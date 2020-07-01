package niu.study.DesignPattern.singleton;

import java.lang.ref.PhantomReference;

/**
 * 饿汉式：
 * 直接创建实例对象，不管你是否需要这个对象
 * 1.构造器私有化
 * 2.自行创建，并用静态变量保存
 * 3.向外提供这个实例
 * 4.强调这是一个单例，我们可以用final修饰
 */
public class Hungry {
    //可能会浪费空间
    private byte[] data = new byte[1024*1024];
    private Hungry(){

    }
    public static final Hungry HUNGRY = new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;
    }

}
