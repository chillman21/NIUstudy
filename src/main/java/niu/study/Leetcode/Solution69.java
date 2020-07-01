package niu.study.Leetcode;

public class Solution69 {
    public static int newSqrt(int x) {//二分查找法
        if (x < 2) return x;//x小于2时平方根即是本身
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = (left+right) / 2;//取一个基准值进行比较
            if ((long)pivot * pivot > x) right = pivot - 1;//估大了，右端收
            else if ((long)pivot * pivot < x) left = pivot + 1;//估小了，左端进
            else return pivot;
        }
        return right;
    }
    static int s;

    public static int newSqrt2(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }

    public static double sqrts(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }


    public static void main(String[] args) {
        System.out.println(newSqrt2(999999999));
    }
    /**
     * 输出结果：
     * 2
     *
     * Process finished with exit code 0
     */
}
