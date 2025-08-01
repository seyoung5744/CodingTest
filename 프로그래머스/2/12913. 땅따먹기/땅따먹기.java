import java.util.Arrays;

public class Solution {

    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; ++k) {
                    if (k == j) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                }
            }
        }
        return Arrays.stream(dp[land.length-1]).max().getAsInt();
    }
}
