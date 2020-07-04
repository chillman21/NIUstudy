package niu.study.swordpointoffer;

public class Solution53_I {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    //查找右边界
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1; //找到第一个比目标值大的数的下标
            else j = m - 1;
        }
        return i;
    }

}
