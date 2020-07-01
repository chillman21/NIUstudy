package niu.study.DesignPattern;

public class Father {
    private int i = fuck();
    public int fuck(){
        System.out.println("fuck by father");
        return 1;
    }
    public int fuck2(){
        System.out.println("fuck2 by father");
        return 1;
    }
}
