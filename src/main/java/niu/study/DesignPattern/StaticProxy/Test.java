package niu.study.DesignPattern.StaticProxy;

public class Test {
    Person person = new Person("*****父类调用");
    static{
        System.out.println("父类静态代码块");
    }

    public Test() {
        System.out.println("父类构造方法");
    }
    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    static{
        System.out.println("成员变量调用类的静态代码块");
    }
    public Person(String str) {
        System.out.println("成员变量调用类的构造方法"+str);
    }
}


class MyClass extends Test {
    Person person = new Person("*****子类调用");
    static{
        System.out.println("子类静态代码块");
    }

    public MyClass() {
        System.out.println("子类构造方法");
    }
}