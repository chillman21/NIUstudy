package niu.study.DesignPattern.StaticProxy;
//代理角色
public class WeddingCompany implements Marry{
    private  Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("布置现场");
    }
    private void after() {
        System.out.println("打扫");
    }
}
