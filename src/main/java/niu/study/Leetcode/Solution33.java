package niu.study.Leetcode;

/**
 * @author NIU
 * @createTime 2020/7/28 13:11
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {//左端
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {//在mid左边
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {//右端
                if (target > nums[mid] && target <= nums[hi]) {//在mid右边
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(new Solution33().search(nums, 3));
    }
}
