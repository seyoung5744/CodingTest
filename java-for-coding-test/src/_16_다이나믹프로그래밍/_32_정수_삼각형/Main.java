package _16_다이나믹프로그래밍._32_정수_삼각형;

import java.util.*;

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
public class Main {

    public static int[][] dp = new int[500][500];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int leftUp, up;

                if (j == 0) leftUp = 0;
                else leftUp = dp[i-1][j-1];

                if(j == i) up = 0;
                else up = dp[i-1][j];

                dp[i][j] = dp[i][j] + Math.max(leftUp, up);
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.println(result);
    }
}
