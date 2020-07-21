package niu.study.DesignPattern.builder;

/**
 * @author NIU
 * @createTime 2020/7/21 15:09
 */
public class Director {
    public static Robot createRobotByDirector(IBuildRobot ibr) {
        ibr.buildHead();
        return ibr.createRobot();
    }
}
