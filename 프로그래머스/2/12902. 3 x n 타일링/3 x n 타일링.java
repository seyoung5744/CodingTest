class Solution {
    public static long[] dp = new long[5_001];
    public static final int MOD = 1_000_000_007;

    public static int solution(int n) {
        dp[2] = 3;
        dp[4] = 11;

        for (int i = 6; i <= n; i += 2) {
            dp[i] = ((dp[i - 2] * 4) - dp[i - 4] + MOD) % MOD;
        }

        return (int) dp[n];
    }
}