package niu.study.nowcoder;

import java.util.Scanner;

public class Huawei14 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int dec = sc.nextInt();
            int count = 0;
            while(dec>0){
                if((dec&1)>0) count ++;
                dec=dec>>1;
            }
            System.out.println(count);
        }
    }
}
