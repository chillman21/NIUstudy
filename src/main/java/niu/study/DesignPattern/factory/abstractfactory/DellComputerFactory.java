package niu.study.DesignPattern.factory.abstractfactory;

import niu.study.DesignPattern.factory.abstractfactory.entity.DellKeyboard;
import niu.study.DesignPattern.factory.abstractfactory.entity.DellMouse;
import niu.study.DesignPattern.factory.abstractfactory.entity.Keyboard;
import niu.study.DesignPattern.factory.abstractfactory.entity.Mouse;

/**
 * @author NIU
 * @createTime 2020/8/8 3:41
 */
public class DellComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
