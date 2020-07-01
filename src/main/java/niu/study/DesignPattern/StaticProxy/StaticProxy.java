package niu.study.DesignPattern.StaticProxy;

/**
 * 静态代理模式总结:
 * 真实对象和代理对象要实现同一个接口
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
        System.out.println("=====");
        new You().HappyMarry();
        new Thread(()-> System.out.println("lamda表达式")).start();
        CharSequence cs = new StringBuilder();
    }
}
