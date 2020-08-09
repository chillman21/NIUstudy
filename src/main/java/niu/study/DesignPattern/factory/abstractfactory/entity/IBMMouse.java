package niu.study.DesignPattern.factory.abstractfactory.entity;

public class IBMMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是联想旗下的IBM鼠标");
    }
}
