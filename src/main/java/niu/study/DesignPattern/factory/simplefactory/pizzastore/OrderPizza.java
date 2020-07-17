package niu.study.DesignPattern.factory.simplefactory.pizzastore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType;
//        while (true) {
//            orderType = getType();
//            if ("greek".equals(orderType)) {
//                pizza = new GreekPizza();
//            } else if ("cheese".equals(orderType)) {
//                pizza = new CheesePizza();
//            } else break;
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }
//    }
    //定义一个简单工厂对象
    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        while (true) {

        }
    }

    private String getType() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input pizza kind:");
            String str = null;
            str = reader.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
