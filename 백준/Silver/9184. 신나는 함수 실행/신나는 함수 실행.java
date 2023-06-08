import java.util.Scanner;

public class Main {

    public static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.printf("w(%d, %d, %d) = ", a, b, c);
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println(1);
                continue;
            }
            if (a > 20 || b > 20 || c > 20) {
                a = b = c = 20;
            }
            int[][][] dp = new int[a + 1][b + 1][c + 1];
            System.out.println(w(dp, a, b, c));
        }

    }

    public static int w(int[][][] dp, int a, int b, int c) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    } else {
                        dp[i][j][k] =
                            dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                    }
                }

            }
        }
        return dp[a][b][c];
    }

}
