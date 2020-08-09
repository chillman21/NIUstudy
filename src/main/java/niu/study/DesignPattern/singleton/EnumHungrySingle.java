package niu.study.DesignPattern.singleton;

import java.lang.reflect.Constructor;

/**
 * 装备了枚举的饿汉模式能够抵御反射和序列化攻击，满足容器需求
 * @author NIU
 * @createTime 2020/8/9 18:13
 */
public class EnumHungrySingle {
    private EnumHungrySingle(){}

    public static EnumHungrySingle getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private EnumHungrySingle instance;
        ContainerHolder() {
            instance = new EnumHungrySingle();
        }
    }



    public static void main(String[] args) throws Exception {
        System.out.println(EnumHungrySingle.getInstance());
        Class<EnumHungrySingle> clazz = EnumHungrySingle.class;
        Constructor<EnumHungrySingle> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumHungrySingle enumHungrySingle = constructor.newInstance();
        System.out.println(enumHungrySingle.getInstance());
        //***************************
        Class<ContainerHolder> clazz1 = ContainerHolder.class;
        Constructor<ContainerHolder> constructor1 = clazz1.getDeclaredConstructor(String.class, int.class);
        constructor1.setAccessible(true);
        System.out.println(constructor1.newInstance());
    }
}
