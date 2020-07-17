package niu.study.DesignPattern.factory.simplefactory.pizzastore;

public class SimpleFactory {

    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
