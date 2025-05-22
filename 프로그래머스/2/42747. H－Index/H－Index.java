import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 0 1 3 5 6
        Arrays.sort(citations);
        
        for (int h = citations[citations.length - 1]; h >= 0; h--) {
            int count = 0;
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[j] < h) break;
                
                count++;
            }
            
            if (h <= count && citations.length - count <= h) {
                return h;
            }
        }
        return -1;
    }
}