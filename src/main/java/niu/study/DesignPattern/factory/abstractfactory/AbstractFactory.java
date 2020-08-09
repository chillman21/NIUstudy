package niu.study.DesignPattern.factory.abstractfactory;

import niu.study.DesignPattern.factory.abstractfactory.entity.Keyboard;
import niu.study.DesignPattern.factory.abstractfactory.entity.Mouse;

/**
 * 抽象工厂模式
 *      提供一个创建一系列相关或相互依赖对象的接口
 *          抽象工厂模式侧重的是同一产品族
 *          工厂方法模式更加侧重于同一产品等级
 *       解决了工厂模式只支持生产一种产品的弊端
 *          新增一个产品族，只需要增加一个具体工厂，不需要修改代码
 *      ！！！！！
 *      对工厂模式进行了抽象
 *        工厂方法模式： 每个抽象产品派生出多个具体产品类，每个抽象工厂类派生多个
 *        具体工厂类，每个具体工厂类负责一个具体产品的实例创建。
 *        抽象工厂模式： 每个抽象产品派生出多个具体产品类，每个抽象工厂类派生多个
 *        具体工厂类，每个具体工厂类负责一系列具体产品的实例创建。
 *     缺点：添加新产品时依旧违背开闭原则，增加系统复杂度
 * @author NIU
 * @createTime 2020/8/8 3:33
 */
public class AbstractFactory {
    public static void main(String[] args) {
        ComputerFactory cf = new HpComputerFactory();
        Mouse mouse = cf.createMouse();
        Keyboard keyboard = cf.createKeyboard();
        mouse.sayHi();
        keyboard.sayHello();
    }
}
