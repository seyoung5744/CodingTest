package _16_다이나믹프로그래밍._35_못생긴수;

import java.util.*;

public class Main {

    public static int n;
    public static int[] dp = new int[1001];

    public static int a, b, c;
    public static int nextA, nextB, nextC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        nextA = 2;
        nextB = 3;
        nextC = 5;
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(nextA, Math.min(nextB, nextC));
            System.out.println(nextA + ", " + nextB + ", " + nextC + " ==> " + dp[i]);
            if (dp[i] == nextA) {
                a += 1;
                nextA = dp[a] * 2;
            }
            if (dp[i] == nextB) {
                b += 1;
                nextB = dp[b] * 3;
            }
            if (dp[i] == nextC) {
                c += 1;
                nextC = dp[c] * 5;
            }
        }

        System.out.println(dp[n-1]);


    }

}
