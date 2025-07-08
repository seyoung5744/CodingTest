import java.util.*;

class Solution {
    public long solution(long n) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        while (n > 0) {
            pq.offer((int)(n % 10));
            n /= 10L;
        }
        
        long answer = 0;
        
        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer = answer * 10 + num;
        }
        return answer;
    }
}