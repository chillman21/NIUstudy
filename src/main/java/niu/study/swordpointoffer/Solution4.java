package niu.study.swordpointoffer;
//二维数组中的查找 leetcode4
public class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return false;
        }
        // 左下
        int row = rows-1;
        int col = 0;
        while(row>=0 && col<=cols-1){
            if(matrix[row][col] < target){
                col++;
            }else if(matrix[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] nums ={{1,2},{3,4},{5,6}};
        System.out.println(solution4.findNumberIn2DArray(nums,4));
    }
}
