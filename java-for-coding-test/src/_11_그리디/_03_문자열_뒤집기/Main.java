package _11_그리디._03_문자열_뒤집기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int group1 = 0;
        int group2 = 0;

        if (str.charAt(0) == '0') {
            group1 += 1;
        } else {
            group2 += 1;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '0') {
                    group1 += 1;
                } else {
                    group2 += 1;
                }
            }
        }

        int result = Math.min(group1, group2);
        System.out.println(result);
    }

}
