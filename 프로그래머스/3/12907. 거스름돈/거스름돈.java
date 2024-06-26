public class Solution {

    public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int coin : money) {
            for (int i = coin; i < n + 1; i++) {
                dp[i] += dp[i - coin] % 1_000_000_007;
            }
        }

        return dp[n];
    }
}
