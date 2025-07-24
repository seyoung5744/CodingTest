import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }

        int answer = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[1] == pq.peek()) {
                pq.poll();
                if (cur[0] == location) {
                    break;
                }
                answer++;
            } else {
                q.offer(cur);
            }
        }
        return answer;
    }
}