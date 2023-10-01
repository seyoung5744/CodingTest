import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(bridge(M, N));
        }
    }

    public static int bridge(int N, int M) {

        if (dp[N][M] > 0) {
            return dp[N][M];
        }

        if (M == 0 || M == N) {
            return dp[N][M] = 1;
        }

        return dp[N][M] = bridge(N - 1, M - 1) + bridge(N - 1, M);
    }

}
