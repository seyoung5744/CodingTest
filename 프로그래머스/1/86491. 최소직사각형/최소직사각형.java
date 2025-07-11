import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;

        int[] width = new int[len];
        int[] height = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
                if (sizes[i][0] > sizes[i][1]) {
                    width[i] = sizes[i][0];
                    height[i] = sizes[i][1];
                } else {
                    width[i] = sizes[i][1];
                    height[i] = sizes[i][0];
                }
            }
        }

        Arrays.sort(width);
        Arrays.sort(height);

        return width[len - 1] * height[len - 1];
    }
}