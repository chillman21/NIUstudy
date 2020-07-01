package niu.study.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */
class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
          int differ = target - nums[i];
          //System.out.println(map.get(differ));
          if (map.containsKey(differ) && (map.get(differ)!= i)){
              return new int[] {i,map.get(differ),};
          }
        }
        throw new IllegalArgumentException("集合中不存在两个数相加为目标值。");
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{3,3,3,3,3},6)));
    }
}
