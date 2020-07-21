package niu.study.DesignPattern.factory.simplefactory;

/**
 * @author NIU
 * @createTime 2020/7/21 14:33
 */
public class SimpleFactory {
    // 工厂角色
    public static Car produceCar(String str) {
        //接口引用
        Car car = null;
        if ("BMW".equals(str)) {
            car = new BMW();
        }
        if ("LandRover".equals(str)) {
            car = new LandRover();
        }
        return car;
    }
    public static void main(String[] args) {
        Car car = SimpleFactory.produceCar("BMW");
        car.run();
    }
}
