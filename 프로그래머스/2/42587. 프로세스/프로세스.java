
import java.util.*;

public class Solution {

    static class Process {

        int priority;
        int index;

        public Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> q = new LinkedList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
            pq.offer(priorities[i]);
        }

        while (!q.isEmpty()) {
            Process cur = q.poll();

            if (cur.priority == pq.peek()) {
                pq.poll();

                if (cur.index == location)
                    break;

                ++answer;
            } else {
                q.offer(cur);
            }

        }
        return answer;
    }

}
