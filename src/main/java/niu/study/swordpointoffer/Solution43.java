package niu.study.swordpointoffer;

public class Solution43 {
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            //当前位数字为0时 为高位数字*digit
            if(cur == 0) res += high * digit;
            //当前位数字为1时 为高位数字*digit + 低位数字*1 + 低位为0时的一个数
            else if(cur == 1) res += high * digit + low + 1;
            //当前位数字大于1时    高位数字*digit + 低位digit*1
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
