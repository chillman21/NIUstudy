package niu.study.DesignPattern.factory.abstractfactory;

import niu.study.DesignPattern.factory.abstractfactory.entity.*;

/**
 * @author NIU
 * @createTime 2020/8/8 3:41
 */
public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
