package niu.study.DesignPattern.builder;

/**
 * 建造者模式的使用场合是当创建复杂对象的时候，
 * 把创建对象成员和装配方法分离出来，
 * 放在建造者类中去实现，当用户使用该复杂对象的时候，
 * 不用理会它的创建和装配过程，只需要它的表现形式。
 * @author NIU
 * @createTime 2020/7/21 15:11
 */
public class BuilderTest {
    public static void main(String[] args){
        DanceRobotBuilder builder = new DanceRobotBuilder();
        Robot robot = Director.createRobotByDirector(builder);
        System.out.println(robot.getHead());
        System.out.println("机器人创建成功，恭喜！");
    }
}
