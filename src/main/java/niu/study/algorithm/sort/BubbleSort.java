package niu.study.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序 优化版
 * 时间复杂度：O(n²)
 * 最坏情况是把顺序的排列变成逆序，或者把逆序的数列变成顺序
 */
public class BubbleSort {
    public void bubbleSort(int[] a)
    {
        //外层循环，是需要进行比较的轮数，一共进行（长度-1）次即可
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            //内层循环，是每一轮中进行的两两比较
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            System.out.println("第"+(i+1)+"轮排序后的数组为: "+ Arrays.toString(a));
            if (flag) return;
        }
    }

    public static void main(String[] args) {
        int[] nums = {6,1,2,3,4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        int i = Integer.parseInt("1024");
        int i1 = Integer.valueOf("1024").intValue();
        System.out.println(i ==  i1);
    }
}
