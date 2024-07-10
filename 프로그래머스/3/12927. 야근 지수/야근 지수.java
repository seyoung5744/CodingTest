import java.util.PriorityQueue;

public class Solution {

    public static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int work : works) {
            pq.offer(work);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            if(cur -1 == 0)
                continue;
            pq.offer(cur - 1);
        }

        while (!pq.isEmpty()) {
            answer += (int) Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }

}
