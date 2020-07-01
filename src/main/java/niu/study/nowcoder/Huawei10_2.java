package niu.study.nowcoder;
import java.util.Scanner;

public class Huawei10_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        scanner.close();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) <= 127 && string.charAt(i) >= 0 && string.lastIndexOf(string.charAt(i)) == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}