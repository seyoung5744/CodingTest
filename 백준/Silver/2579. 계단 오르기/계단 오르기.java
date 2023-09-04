import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int max;
    private static int[] steps;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        steps = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = steps[0];
        dp[1] = steps[1];

        if (n >= 2) {
            dp[2] = steps[1] + steps[2];
        }

        System.out.println(find(n));
    }

    private static int find(int n) {

        if (dp[n] == null) {

            dp[n] = Math.max(find(n - 2), find(n - 3) + steps[n - 1]) + steps[n];

        }

        return dp[n];
    }
}
