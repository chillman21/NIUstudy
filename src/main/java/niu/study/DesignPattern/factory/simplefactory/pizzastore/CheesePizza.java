package niu.study.DesignPattern.factory.simplefactory.pizzastore;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        this.name = "奶酪披萨";
    }

    @Override
    public void prepare() {
        System.out.println("制作奶酪披萨准备原材料");
    }
}
