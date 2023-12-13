public class Solution {

    public static Integer[] dp;

    public static int MAX = 1_000_000_007;
    public static int solution(int n) {
        dp = new Integer[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MAX;
        }
        return dp[n];
    }
}
