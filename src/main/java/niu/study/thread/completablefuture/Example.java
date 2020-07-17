package niu.study.thread.completablefuture;

public class Example {

    public String name;

    public Example(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        InterfaceExample com =  Example::new;
        Example example = com.create("1");
        System.out.println(example.name);
    }
}

@FunctionalInterface
interface InterfaceExample{
    Example create(String a);
}

