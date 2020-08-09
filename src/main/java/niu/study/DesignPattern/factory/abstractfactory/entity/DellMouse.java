package niu.study.DesignPattern.factory.abstractfactory.entity;

public class DellMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是戴尔鼠标");
    }
}
