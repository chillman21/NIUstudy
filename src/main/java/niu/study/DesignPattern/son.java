package niu.study.DesignPattern;

public class son extends Father {
    private int i = fuck();
    public int fuck(){
        System.out.println("fuck by son");
        return 1;
    }
    public static void main(String[] args) {
        son son = new son();
    }
}
