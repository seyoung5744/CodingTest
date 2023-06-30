import java.util.*;

class Solution {
    private boolean isValid(int[] citations, int h){
        int idx = citations.length - h;
        return citations[idx] >= h;
    }
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        for (int h = citations.length; h >= 1; h--) {
            if(isValid(citations, h)) return h;
        }
        
        return 0;
    }
}