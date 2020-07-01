package niu.study.nowcoder;

import org.junit.Test;

import java.util.*;
public class Huawei5 {
    @Test
    public void test(){
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("0",0);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
        map.put("8",8);
        map.put("9",9);
        map.put("A",10);
        map.put("B",11);
        map.put("C",12);
        map.put("D",13);
        map.put("E",14);
        map.put("F",15);
        while (sc.hasNextLine()) {
            String hex = sc.nextLine().substring(2);
            int index = hex.length() - 1;
            int n = hex.length() - 1;
            //System.out.println(hex.substring(index, index+1));
            int dec = 0;
            while (index >= 0) {
                int wow = map.get(hex.substring(n - index, n - index + 1));

                dec = dec + pow(16, index) * wow;
                System.out.println(dec);
                index--;
            }
            System.out.println(dec);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }
    public static int pow(int x,int y){
        int power = 1;
        for (int i = 0; i < y; i++)
            power *= x;
        return power;
    }


}
