import java.util.*;

public class Solution {

    public static int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        pq1.addAll(Arrays.asList(jobs));

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });


        int result = 0;
        while(!pq1.isEmpty()) {
            while(!pq1.isEmpty() && pq1.peek()[0] <= result) {
                pq2.offer(pq1.poll());
            }

            if (pq2.isEmpty()) {
                pq2.offer(pq1.poll());
            }

            int[] cur = pq2.poll();

            if (result > cur[0]) {
                answer += result - cur[0] + cur[1];
                result += cur[1];
            } else {
                answer += cur[1];
                result = cur[0] + cur[1];
            }
        }

        while (!pq2.isEmpty()) {
            int[] cur = pq2.poll();

            if (result > cur[0]) {
                answer += result - cur[0] + cur[1];
                result += cur[1];
            } else {
                answer += cur[1];
                result += cur[0] + cur[1];
            }
        }

        return answer / jobs.length;
    }

}
