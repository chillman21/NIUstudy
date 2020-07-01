package niu.study.Leetcode;

import java.util.Arrays;

public class Solution56 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        int[] res = new int[2];

        for(int num : nums){
            sum ^= num;
        }
        System.out.println(sum);
        int lowbit = sum & (-sum);
        System.out.println(lowbit);
        for(int num : nums){
            if((num & lowbit) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[] numbers = solution56.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
        System.out.println(Arrays.toString(numbers));
    }
}
