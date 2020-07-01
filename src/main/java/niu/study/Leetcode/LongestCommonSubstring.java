package niu.study.Leetcode;

public class LongestCommonSubstring {
    /**
     * 只用O(N)额外空间
     * @param s1
     * @param s2
     * @return
     */
    public String DPlengthOfLongestCommonSubstring(String s1, String s2){
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return "";
        }
        int start = 0;
        int maxLen = 0;
        int[] table = new int[s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = s2.length() - 1; j >= 0; j--) { //防覆盖，不能正向遍历
                if (i == 0 || j == 0) {
                    if (s1.charAt(i) == s2.charAt(j)){
                        table[j] = 1;
                    } else {
                        table[j] = 0;
                    }
                } else {
                    if (s1.charAt(i) == s2.charAt(j)){
                        table[j] = table[j-1] + 1;
                    } else {
                        table[j] = 0;
                    }
                }

                if (table[j] > maxLen){
                    maxLen = table[j];
                    start = i - maxLen + 1;
                }
            }
        }
        return s1.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s1 = "abdc";
        String s2 = "dc";
        System.out.println(new LongestCommonSubstring().DPlengthOfLongestCommonSubstring(s1, s2));
    }
}
