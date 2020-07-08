package niu.study.swordpointoffer;

public class Solution64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = (n > 1 && sumNums(n - 1) > 0);
        System.out.println("res+="+ n);
        res += n;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution64().sumNums(5));
    }
}
