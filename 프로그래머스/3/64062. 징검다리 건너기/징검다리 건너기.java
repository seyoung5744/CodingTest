import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int start = 1;
        int end = 200_000_000;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            int length = 1;
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < stones.length; i++) {
                if(stones[i] - mid < 0) {
                    length++;
                } else {
                    length = 1;
                }
                max = Math.max(max, length);
            }
            
            if(max > k) {
                end = mid - 1;  
            } else {
                start = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}