package niu.study.swordpointoffer;

public class Solution5 {
    public String replaceSpace(String s) {
        char[] array = new char[s.length()*3];
        int size = 0;
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if( c ==' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        String str = new String(array , 0 , size);
        return str;
    }
    public String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }
}
