import java.util.*;

public class Solution {
    public static int[][] dp = new int[501][501];

    public static int solution(int[][] triangle) {
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return max(0, 0, triangle);
    }

    public static int max(int x, int y, int[][] triangle) {
        if(y == triangle.length) {
            return 0;
        }

        if(dp[y][x] != -1) {
            return dp[y][x];
        }

        return dp[y][x] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
    }
}
