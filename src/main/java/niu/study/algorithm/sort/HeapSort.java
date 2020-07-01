package niu.study.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //Ascending order
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //堆排序方法
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("heapSort!");
        adjustHeap(arr,1,arr.length);

        for (int i = arr.length/2 - 1; i >= 0; i--)//i的初始值：最后一个非叶子节点的下标 i
            adjustHeap(arr,i,arr.length);
        System.out.println("第一次："+ Arrays.toString(arr));
        for (int j = arr.length - 1 ; j > 0 ; j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }
    //将一个数组（二叉树）调整成一个大顶堆

    /**
     *  功能：将会完成以i对应的最后一个非叶子节点的树调整成局部大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引下标
     * @param length 表示对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        //开始调整
        for (int k = i * 2 + 1; k < length; k= k* 2 + 1) {//k为当前节点的左子节点，由于k<length叶子节点无法进入此循环
            if (k+1 < length && arr[k]<arr[k+1]) k++;//左子节点的值小于右子节点
            if(arr[k] > temp){//子节点大于父节点
                arr[i] =arr[k];
                i = k;//让i指向k，继续循环比较
            }else break;
        }
        //for循环结束后，已经形成局部大顶堆
        arr[i] = temp;
    }
}
