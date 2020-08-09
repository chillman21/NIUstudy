package niu.study.DesignPattern.factory.simplefactory;

/**
 * 简单工厂模式
 *      优点：
 *          可以对创建的对象进行“加工”，对客户端隐藏相关细节
 *       缺点：
 *          1.因创建逻辑复杂或创建对象过多而造成代码臃肿
 *          2.新增、删除子类均会违反开闭原则
 *
 *   开闭原则：一个软件实体，应该对扩展开放，对修改关闭
 *          应该通过扩展来实现变化，而不是通过修改已有的代码来实现变化
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
