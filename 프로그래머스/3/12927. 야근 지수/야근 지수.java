import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            pq.add(work);
        }
        
        while(n-- > 0 && !pq.isEmpty()) {
            int remain = pq.poll() - 1;
            
            if(remain != 0)
                pq.add(remain);
        }
            
        while(!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}