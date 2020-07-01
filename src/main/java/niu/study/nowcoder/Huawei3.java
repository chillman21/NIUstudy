package niu.study.nowcoder;

import java.util.*;

public class Huawei3 {
   /* public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0 ; i < num ;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }
    }
*/
   public static void main(String[] args) {
       Scanner sc  = new Scanner(System.in);
       while(sc.hasNext()){
           int num = sc.nextInt();

           ArrayList<Integer> list = new ArrayList<>();
           for (int i = 0; i < num  ; i++) {
               int curr = sc.nextInt();
               if(!list.contains(curr))
                   list.add(curr);
           }
           Object[] arr = list.toArray();
           Arrays.sort(arr);
           for (Object o : arr) {
               System.out.println(((int) o));
           }
       }
   }
}

