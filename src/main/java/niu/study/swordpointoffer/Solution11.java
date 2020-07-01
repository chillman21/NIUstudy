package niu.study.swordpointoffer;

public class Solution11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
