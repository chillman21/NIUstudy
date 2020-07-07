package niu.study.thread;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends  Thread {
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        List<Object> list = new ArrayList<>();
        while(true) {
            list.add(new Object());
        }
    }

    public static void main(String[] args) {
        MyThread shabi = new MyThread("shabi");
        Thread thread = new Thread();
        shabi.start();
    }
}
