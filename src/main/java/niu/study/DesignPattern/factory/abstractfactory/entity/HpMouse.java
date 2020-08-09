package niu.study.DesignPattern.factory.abstractfactory.entity;

public class HpMouse  implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是惠普鼠标");
    }
}
