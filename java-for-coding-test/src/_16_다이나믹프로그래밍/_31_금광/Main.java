package _16_다이나믹프로그래밍._31_금광;

import java.util.*;

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2

 */
public class Main {
    public static int[][] map = new int[20][20];
    public static int[][] dp = new int[20][20];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = sc.nextInt();
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, left, leftDown;

                    if(i == 0) leftUp = 0;
                    else leftUp = dp[i-1][j-1];

                    if(i == n - 1) leftDown = 0;
                    else leftDown = dp[i+1][j-1];

                    left = dp[i][j-1];
                    dp[i][j] = dp[i][j] + Math.max(left, Math.max(leftUp, leftDown));
                }
            }

            int result = 0;

            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m-1]);
            }

            System.out.println(result);
        }
    }

}
