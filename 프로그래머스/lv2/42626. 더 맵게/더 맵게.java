import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scovil : scoville){
            pq.offer(scovil);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int min1 = pq.poll();
            int min2 = pq.poll();
            pq.offer( min1 + min2 * 2);
            answer++;
        }

        if(pq.size() == 1&& pq.peek() < K){
            return -1;
        }

        return answer;
    }
}