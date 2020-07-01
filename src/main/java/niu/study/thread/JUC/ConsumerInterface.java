package niu.study.thread.JUC;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口：只有输入参数，没有返回值
 */
public class ConsumerInterface {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer =(str)->{System.out.println(str); };
        consumer.accept("sb");
    }
}
