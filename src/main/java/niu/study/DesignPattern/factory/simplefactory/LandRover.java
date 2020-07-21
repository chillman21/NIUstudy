package niu.study.DesignPattern.factory.simplefactory;

/**
 * @author NIU
 * @createTime 2020/7/21 14:41
 */
public class LandRover implements Car {
    @Override
    public void run() {
        System.out.println("路虎");
    }
}
