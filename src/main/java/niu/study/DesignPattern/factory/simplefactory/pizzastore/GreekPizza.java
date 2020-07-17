package niu.study.DesignPattern.factory.simplefactory.pizzastore;

public class GreekPizza extends Pizza {
    public GreekPizza() {
        this.name = "希腊披萨";
    }

    @Override
    public void prepare() {
        System.out.println("制作希腊披萨准备原材料");
    }
}
