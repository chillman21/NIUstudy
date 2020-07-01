package niu.study.swordpointoffer;

import java.util.*;

public class MostTimesString {
    public Character findCharMost(String str) {
        if (str.length() == 0) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        char ans = ' ';
        for (int i= 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            int curCount = map.getOrDefault(cur, 0) + 1;
            if (curCount > count) {
                ans = cur;
                count = curCount;
            }
            map.put(cur, curCount);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MostTimesString().findCharMost("aaabbbcccc"));
    }

}
