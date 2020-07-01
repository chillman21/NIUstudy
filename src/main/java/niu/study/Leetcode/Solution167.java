package niu.study.Leetcode;

import java.util.Arrays;

/**167.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * 题目描述：
     * 在有序数组中找出两个数，使它们的和为 target。
     *思路： 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，
     * 指向较大元素的指针从尾向头遍历。
 */
class Solution167 {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int sum = 0;
        int index1 = 0, index2 = numbers.length - 1;
        while ( index1 < index2) {
            sum = numbers[index1] + numbers[index2];
            //如果 sum > target，移动较大的元素，使 sum 变小一些；
            if (sum > target){
                index2--;
            }
            // 如果 sum < target，移动较小的元素，使 sum 变大一些。
            else if (sum < target){
                index1++;
            }
            //如果两个指针指向元素的和 sum == target，那么得到要求的结果；
            else return new int[] {index1 + 1, index2 + 1};

        }
        throw new IllegalArgumentException("集合中不存在两个数相加为目标值。");
    }

    public static void main(String[] args) {
        int[] numbers={2, 7, 11, 15};
        int target = 26;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

}
