class Solution {
    public static int solution(int n, int[] money) {
        int answer = 0;

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[n];
    }

}