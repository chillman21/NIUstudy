package niu.study.algorithm.sort;

import java.util.Arrays;

/**
 *   快速排序的平均时间复杂度是：O(nlogn)
 *   最差情况下时间复杂度:
 *      最差的情况就是每一次取到的元素就是数组中最小/最大的,退化为冒泡排序，也就是 数组本身有序，
 *      可以通过随机选取 pivot 来解决 ： random.nextInt(r-l) + l + 1。
 *      快速排序最差的情况下时间复杂度为：O(n^2)
 *   快速排序是不稳定的：
 *       体现在相同数字会由于不同pivot的选取在排序后原有顺序改变。
 *
 */
public class  QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,2};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void quickSort(int[] arr){
        System.out.println("初始数组为:"+Arrays.toString(arr));
        quickSort(arr,0,arr.length - 1);
    }
    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        // pivot存放基准数
        int pivot = arr[left];
        int i = left, j = right;
        while (i != j) {

            // 顺序很重要，先从右边开始往左找，直到找到比pivot值小的数
            while (arr[j] >= pivot && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比pivot值大的数
            while (arr[i] <= pivot && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            System.out.println("当前数组为:"+Arrays.toString(arr));
        }

        // 将基准数放到中间的位置（基准数归位）
        System.out.println(i);
        arr[left] = arr[i];
        arr[i] = pivot;
        System.out.println("基准数归位后为:"+Arrays.toString(arr));
        System.out.println("----------");


        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


}
