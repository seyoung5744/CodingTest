import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(triangle(N));
        }
    }

    public static long triangle(int N) {
        if (dp[N] == -1) {
            return dp[N] = triangle(N - 2) + triangle(N - 3);
        }
        return dp[N];
    }

}
