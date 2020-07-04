package niu.study.swordpointoffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution40 {
    // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
    // 1. 若目前堆的大小小于K，将当前数字放入堆中。
    // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
    //    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 默认是小根堆，
            // 实现大根堆需要重写一下比较器。
            Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int num : arr) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }

            // 返回堆中的元素
            int[] res = new int[k];
            int idx = 0;
            for (int num : queue) {
                res[idx++] = num;
            }
            return res;
        }

        /**
         * 方法二为快速选择算法
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers2(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            } else if (arr.length <= k) {
                return arr;
            }

            // 原地不断划分数组
            partitionArray(arr, 0, arr.length - 1, k);

            // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        void partitionArray(int[] arr, int lo, int hi, int k) {
            if (lo > hi) return;
            // 做一次 partition 操作
            int m = partition(arr, lo, hi);
            // 此时数组前 m 个数，就是最小的 m 个数
            if (k == m) {
                // 正好找到最小的 k(m) 个数
                return;
            } else if (k < m) {
                // 最小的 k 个数一定在前 m 个数中，递归划分
                partitionArray(arr, lo, m - 1, k);
            } else {
                // 在右侧数组中寻找最小的 k-m 个数
                partitionArray(arr, m + 1, hi, k);
            }
        }

        // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
        // 代码参考 Sedgewick 的《算法4》
        int partition(int[] a, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            int v = a[lo];
            while (true) {
                while (a[++i] < v) {
                    if (i == hi) {
                        break;
                    }
                }
                while (a[--j] > v) {
                    if (j == lo) {
                        break;
                    }
                }

                if (i >= j) {
                    break;
                }
                swap(a, i, j);
            }
            swap(a, lo, j);

            // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
            return j;
        }

        void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }


}
