package niu.study.thread.JUC;

import java.util.function.Function;

/**
 * Function函数型接口，有一个输入参数，有一个输出
 *
 * 只要是函数式接口，就可以用lambda表达式简化
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        //工具类：输出输入的值
//        Function<String, String> function = new Function<>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        Function<String, String> function = str->{return str;};
        System.out.println(function.apply("sb"));
    }
}
/* 函数式接口：有超级多
作用：简化编程模型，在新版本的框架底层大量运用！
foreach(消费者类型的函数式接口)
@FunctionalInterface
public interface Runnable {
public abstract void run();
}
 四大函数式接口：Consumer、Function、Predicate、Supplier


 */
