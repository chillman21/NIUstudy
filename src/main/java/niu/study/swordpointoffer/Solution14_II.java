package niu.study.swordpointoffer;

public class Solution14_II {
    public int cuttingRope(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }


    public static void main(String[] args) {
        Solution14_II solution14_i = new Solution14_II();
        System.out.println(solution14_i.cuttingRope(5));
    }

}
