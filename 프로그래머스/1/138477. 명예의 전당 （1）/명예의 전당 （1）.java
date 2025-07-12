import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(score[0]);
        answer[0] = pq.peek();
        
        for (int i = 1; i < score.length; i++) {
            int s = score[i];
            
            if (pq.size() < k) {
                pq.offer(s);
            } else if (pq.peek() <= s)
                pq.offer(s);
            
            if (pq.size() > k) {
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}