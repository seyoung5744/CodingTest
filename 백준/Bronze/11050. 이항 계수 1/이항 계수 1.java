import java.util.Scanner;

public class Main {

    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < k + 1; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[n][k]);
    }

}
