import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i >= 1; i--) {
            if (isValid(citations, i)) return i;
        }
        return 0;
    }
    
    public boolean isValid(int[] citations, int h) {
        int idx = citations.length - h;
        return citations[idx] >= h;
    }
}