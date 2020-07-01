package niu.study.algorithm;

import niu.study.algorithm.sort.QuickSort;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] nums, int key) {
        int l = 0 , h = nums.length -1;
        while(l<=h){
            int m = (l+h)/2;
            if( nums[m] == key) return m;
            else if (nums[m] > key) h = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {8,9,5,7,6};
        QuickSort sort = new QuickSort();
        sort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(binarySearch(nums,7));
    }

}
