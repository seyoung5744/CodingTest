import java.util.Arrays;

public class Solution {

    public static Integer[][] dp = new Integer[100_000][4];

    static int solution(int[][] land) {

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + getMax(dp[i - 1], j);
            }
        }

        return Arrays.stream(dp[land.length-1]).mapToInt(Integer::intValue).max().orElseThrow();
    }

    public static int getMax(Integer[] nums, int exclude) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != exclude) {
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }

}
