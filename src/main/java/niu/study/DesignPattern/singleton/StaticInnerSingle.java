package niu.study.DesignPattern.singleton;

/**
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化,它是要单独去加载和初始化的。
 *
 */
public class StaticInnerSingle {
    private StaticInnerSingle(){}
    private static class Inner{
        private static final StaticInnerSingle INSTANCE = new StaticInnerSingle();
    }
    private static StaticInnerSingle getInstance(){
        return Inner.INSTANCE;
    }

}
