package niu.study.DesignPattern.singleton;

/**
 * 枚举类型，你表示该类型的对象是有限的几个
 * 我们可以限定为一个，就成了单例
 */
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
