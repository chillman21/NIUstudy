package niu.study.nowcoder;

import java.util.Scanner;

public class Huawei12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            for(int i =str.length()-1;i>=0 ; i --){
                System.out.print(str.substring(i,i+1));
            }
            System.out.println();
        }
    }
}
