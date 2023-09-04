import java.io.*;
import java.util.*;

public class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 0;
        
        System.out.println(find(N));
    }

    public static int find(int N) {
        if (dp[N] == -1) {
            if (N % 6 == 0) {
                dp[N] = 1 + Math.min(find(N / 3), Math.min(find(N / 2), find(N - 1)));
            } else if (N % 3 == 0) {
                dp[N] = 1 + Math.min(find(N / 3), find(N - 1));
            } else if (N % 2 == 0) {
                dp[N] = 1 + Math.min(find(N / 2), find(N - 1));
            } else {
                dp[N] = 1 + find(N - 1);
            }
        }

        return dp[N];
    }

}
