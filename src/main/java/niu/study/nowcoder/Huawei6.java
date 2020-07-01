package niu.study.nowcoder;

import java.util.Scanner;

public class Huawei6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()){
            long num = sc.nextLong();
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        num /= i;
                        System.out.print(i+" ");
                        break;//java中一个break只跳出一层循环
                    }
                }
            }
        }
    }
}
