package niu.study.DesignPattern;

public class TestLambda {
    public static void main(String[] args) {
        ILike like1 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda");
            }
        };
        like1.lambda();
        ILike2 like2 = ()->{ System.out.println("lambda"); };
        like2.lambda();
    }
}
interface ILike{
    void lambda();
}
interface ILike2{
    void lambda();
}
