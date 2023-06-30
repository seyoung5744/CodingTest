import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = 0;
            
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[i] <= citations[j]) {
                    h++;
                }
            }

            if(citations[i] >= h && citations.length - h <= h){
                answer = h;
            }
        }
        return answer;
    }
}