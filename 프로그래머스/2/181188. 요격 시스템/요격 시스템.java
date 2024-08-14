import java.util.PriorityQueue;

public class Solution {

    public static int solution(int[][] targets) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for (int[] target : targets) {
            pq.add(target);
        }

        int answer = 0;

        int end = -1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] >= end) {
                answer++;
                end = cur[1];
            } else {
                end = Math.min(end, cur[1]);
            }
        }
        return answer;
    }
}
