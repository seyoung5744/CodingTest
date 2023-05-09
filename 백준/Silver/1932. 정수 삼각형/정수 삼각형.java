import java.util.*;

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
