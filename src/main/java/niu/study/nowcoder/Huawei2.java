package niu.study.nowcoder;


import java.util.Scanner;

public class Huawei2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String substr = scan.nextLine();
        System.out.println(method(str, substr));

    }
    public static int method(String str,String substr){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.toUpperCase().charAt(i) == substr.toUpperCase().charAt(0)) count++;
        }
        return count;
    }
}