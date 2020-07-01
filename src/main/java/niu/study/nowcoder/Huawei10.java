package niu.study.nowcoder;

import java.util.*;

public class Huawei10 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String container ="";
            int count = 0;
            for(int i=0;i<str.length();i++){
                if(!container.contains(str.charAt(i)+"")){
                    container = container + str.charAt(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
