package niu.study.DesignPattern.facade;

/**
 * 客户
 * @author NIU
 * @createTime 2020/8/1 21:39
 */
public class Client {
    public static void main(String[] args) {
        LabourContractor labourContractor = new LabourContractor();
        labourContractor.buildHouse();
    }
}
