package niu.study.nowcoder;

import java.util.*;

public class Huawei8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
            for(int i = 0;i < num;i++){
                int key = sc.nextInt();
                int value = sc.nextInt();
                if(!map.containsKey(key)){
                    map.put(key,value);
                }else{
                    int value0 = map.get(key);
                    map.put(key,value0+value);
                }

            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " "+ entry.getValue());
            }
        }
    }
}
