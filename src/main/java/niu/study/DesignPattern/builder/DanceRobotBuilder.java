package niu.study.DesignPattern.builder;

/**
 * @author NIU
 * @createTime 2020/7/21 14:58
 */
public class DanceRobotBuilder implements IBuildRobot {
    Robot robot;
    public DanceRobotBuilder(){
        robot = new Robot ();
    }
    @Override
    public void buildHead() {
        robot.setHead("写入机械舞程序");
    }
    @Override
    public Robot createRobot () {
        return robot;
    }
}
