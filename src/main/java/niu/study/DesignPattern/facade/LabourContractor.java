package niu.study.DesignPattern.facade;

import niu.study.DesignPattern.facade.subclasses.BrickLayer;
import niu.study.DesignPattern.facade.subclasses.BrickWorker;
import niu.study.DesignPattern.facade.subclasses.Mason;

/**
 * 包工头
 * @author NIU
 * @createTime 2020/8/1 21:39
 */
public class LabourContractor {
    private Mason worker1 = new Mason();
    private BrickLayer worker2 = new BrickLayer();
    private BrickWorker worker3 = new BrickWorker();

    public void buildHouse() {
        worker1.mix();
        worker2.carry();
        worker3.neat();
    }
}
