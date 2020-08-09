package niu.study.test;

import java.util.ArrayList;
import java.util.Iterator;

public interface niu2 {
    public static void main(String[] args) {
        System.out.println("Aa");
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
                iterator.remove();
        }
        for (String s : list) {
            list.remove(1);
        }
        System.out.println(list.toString());
    }
}
