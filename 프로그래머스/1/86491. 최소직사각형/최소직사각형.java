import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = -1;
        int maxHeight = -1;
        
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
                int w = Math.max(sizes[i][0], sizes[i][1]);
                int h = Math.min(sizes[i][0], sizes[i][1]);
                
                maxWidth = Math.max(maxWidth, w);
                maxHeight = Math.max(maxHeight, h);
            }
        }

        return maxWidth * maxHeight;
    }
}