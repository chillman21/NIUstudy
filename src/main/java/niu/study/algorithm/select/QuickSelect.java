package niu.study.algorithm.select;

public class QuickSelect {
    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j --;
            }
            while (i < j && nums[i] <= nums[left]) {
                i ++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        if(k == i - left + 1) {
            return nums[i];
        }
        else if(k < i - left + 1) {
            return quickSelect(nums, left, i - 1, k);
        }
        else {
            return quickSelect(nums, i + 1, right, k - (i - left + 1));
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
