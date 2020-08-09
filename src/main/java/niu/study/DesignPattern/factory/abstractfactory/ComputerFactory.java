package niu.study.DesignPattern.factory.abstractfactory;

import niu.study.DesignPattern.factory.abstractfactory.entity.Keyboard;
import niu.study.DesignPattern.factory.abstractfactory.entity.Mouse;

/**
 * @author NIU
 * @createTime 2020/8/8 3:39
 */
public interface ComputerFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}
