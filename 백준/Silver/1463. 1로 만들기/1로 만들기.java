import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (N <= 3) {
            System.out.println(1);
            return;
        }
        // x % 3 == 0 ? x /= 3
        // x % 2 == 0 ? x /= 2
        // else x -= 1

        Arrays.fill(dp, INF);
        dp[2] = 1;
        dp[3] = 1;
        for (int x = 4; x < N + 1; x++) {
            if (x % 3 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 3] + 1);
            }

            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + 1);
            }

            dp[x] = Math.min(dp[x], dp[x - 1] + 1);
        }
        System.out.println(dp[N]);
        br.close();
    }
}
