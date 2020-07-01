package niu.study.nowcoder;
import java.util.*;
public class Huawei4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = supplyZero(sc.nextLine())+supplyZero(sc.nextLine());
            for(int i = 0;i<str.length()/8;i++){
                System.out.println(str.substring(8*i,8*i+8));
            }
        }
    }
    public static String supplyZero(String str){
        int len = 0;
        if(str.length()%8>0){
            len = str.length()/8+1;
        }else len = str.length()/8;
        int num = len*8-str.length();
        while(num-->0)str = str + "0";
        return str;
    }

}