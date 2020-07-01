package niu.study.nowcoder;

import java.util.*;

public class Huawei9 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            List<String> list = new ArrayList<String>();
            String num = sc.nextLine();
            for(int i=num.length()-1;i>=0;i--){
                if(!list.contains(num.substring(i,i+1)))
                    list.add(num.substring(i,i+1));
            }
            for(String item : list){
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
