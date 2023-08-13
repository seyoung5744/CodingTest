import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Long[] dp = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = dp[2] = dp[3] = 1L;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(triangle(num));
        }
    }

    private static Long triangle(int n) {

        if (dp[n] == null) {
            dp[n] = triangle(n - 2) + triangle(n - 3);
        }

        return dp[n];
    }

}
