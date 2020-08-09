package niu.study.DesignPattern.factory.factorymethod;

import niu.study.DesignPattern.factory.factorymethod.impl.BMWFactory;
import niu.study.DesignPattern.factory.simplefactory.Car;

/**
 * 工厂方法模式：
 *      定义一个用于创建对象的接口，让子类决定实例化哪一类
 *      对类的实例化延迟到其子类
 *      简单工厂模式的进一步抽象和拓展，但是也有其不足
 *
 *      优点： 遵循开闭原则
 *            对客户端隐藏对象的创建细节
 *            遵循单一职责
 *
 *      缺点：
 *            添加子类的时候“拖家带口”
 *            只支持同一类产品的创建
 * @author NIU
 * @createTime 2020/8/8 3:16
 */
public class FactoryMethod {
    public static void main(String[] args) {
        BMWFactory bmwFactory = new BMWFactory();
        Car car = bmwFactory.produceCar();
        car.run();
    }
}
