import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(bridge(N, M));
        }

        br.close();
    }

    private static int bridge(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < m + 1; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }
}
