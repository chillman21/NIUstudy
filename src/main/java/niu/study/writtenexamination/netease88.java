package niu.study.writtenexamination;

import java.util.Scanner;

/**
 * 给个数组，每个数字都可以无限拆分，问数组最多能拆出多少个素数
 * @author NIU
 * @createTime 2020/8/9 1:47
 */
public class netease88 {
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) ans += sc.nextInt() >> 1;
        System.out.print(ans);
    }
}
