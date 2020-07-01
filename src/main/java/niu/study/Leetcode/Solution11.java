package niu.study.Leetcode;

public class Solution11 {
    public static int maxArea(int[] height) {
        int a = 0,b = height.length - 1;
        int maxSize = 0;
        while(a<b){
            maxSize= Math.max(maxSize,(b-a)*Math.min(height[a], height[b]));
            if (height[a]>height[b])b--;
            else a++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
