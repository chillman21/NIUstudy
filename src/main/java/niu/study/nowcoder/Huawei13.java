package niu.study.nowcoder;

import java.util.Scanner;

public class Huawei13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] sentence = str.split(" ");
            for(int i=sentence.length-1;i>=0;i--){
                System.out.print(sentence[i]+" ");
            }
            System.out.println();
        }
    }
}
