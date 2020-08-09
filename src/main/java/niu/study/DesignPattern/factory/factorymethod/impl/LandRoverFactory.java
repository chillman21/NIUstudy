package niu.study.DesignPattern.factory.factorymethod.impl;

import niu.study.DesignPattern.factory.factorymethod.CarFactory;
import niu.study.DesignPattern.factory.simplefactory.Car;
import niu.study.DesignPattern.factory.simplefactory.LandRover;

/**
 * @author NIU
 * @createTime 2020/8/8 3:24
 */
public class LandRoverFactory implements CarFactory {
    @Override
    public Car produceCar() {
        return new LandRover();
    }
}
