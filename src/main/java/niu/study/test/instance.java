package niu.study.test;

import niu.study.test.entity.Human;
import niu.study.test.entity.Man;
import niu.study.test.entity.Woman;

import java.util.*;

public class instance {
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        if(man instanceof Man) System.out.println("1");
        if(man instanceof Woman) System.out.println("4");
        if(woman instanceof Woman) System.out.println("2");
        if(woman instanceof Man) System.out.println("5");

    }




}
