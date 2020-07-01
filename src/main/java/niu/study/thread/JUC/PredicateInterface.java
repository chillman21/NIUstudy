package niu.study.thread.JUC;

import java.util.function.Predicate;

public class PredicateInterface {
    /**
     * 断定型接口：有一个输入参数，返回值只能是 布尔值！
     */
    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate<String> predicate = new Predicate<>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty(); //为空为true
//            }
//        };
        Predicate<String> predicate =(str)->{return str.isEmpty();};
        System.out.println(predicate.test(""));
    }
}
