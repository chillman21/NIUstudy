package niu.study.nowcoder;

import java.util.Scanner;

public class Huawei7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double i = sc.nextDouble();
            System.out.println((int)(i+0.5));
            //或者//System.out.println(Math.round(i));
        }
    }
}
