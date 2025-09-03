import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n + 1];
        dp[1] = wines[1];
        if (n > 1)
            dp[2] = wines[2] + wines[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(wines[i] + dp[i - 2], Math.max(dp[i - 1], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        System.out.println(dp[n]);

        br.close();
    }
}
