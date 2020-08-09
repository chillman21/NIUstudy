package niu.study.DesignPattern.factory.factorymethod.impl;

import niu.study.DesignPattern.factory.factorymethod.CarFactory;
import niu.study.DesignPattern.factory.simplefactory.BMW;
import niu.study.DesignPattern.factory.simplefactory.Car;

/**
 * @author NIU
 * @createTime 2020/8/8 3:24
 */
public class BMWFactory implements CarFactory {
    @Override
    public Car produceCar() {
        return new BMW();
    }
}
