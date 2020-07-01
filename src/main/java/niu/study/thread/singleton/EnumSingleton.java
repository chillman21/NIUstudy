package niu.study.thread.singleton;

import java.lang.reflect.Constructor;

/**
 * enum是什么？本身也是一个Class类
 */
public enum EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
class Test{
    public static void main(String[] args) throws Exception {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        /** 普通反编译和查看class字节码文件看到的枚举类都是无参构造器
         * 事实上并不是这样，使用专业的反编译工具jad可以看到枚举类的源码如下：
         * 枚举类型的最终反编译源码：
         * // Source File Name: EnumSingle.java
         * package niu.servlet.thread.singleton;
         * public final class EnumSingle extends Enum
         * {
         * public static EnumSingle[] values()
         * {
         * return (EnumSingle[])$VALUES.clone();
         * }
         * public static EnumSingle valueOf(String name)
         * {
         * return (EnumSingle)Enum.valueOf(com/kuang/single/EnumSingle, name);
         * }
         * private EnumSingle(String s, int i)
         * {
         * super(s, i);
         * }
         * public EnumSingle getInstance()
         * {
         * return INSTANCE;
         * }
         * public static final EnumSingle INSTANCE;
         * private static final EnumSingle $VALUES[];
         * static
         * {
         * INSTANCE = new EnumSingle("INSTANCE", 0);
         * $VALUES = (new EnumSingle[] {
         * INSTANCE
         * });
         * }
         * }
         *
         */

        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton enumSingleton = declaredConstructor.newInstance();
    }
}
