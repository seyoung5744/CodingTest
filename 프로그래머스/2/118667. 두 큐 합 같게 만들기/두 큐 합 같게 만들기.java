import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; ++i) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        int answer = 0;

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                int q1Num = q1.poll();
                sum1 -= q1Num;
                sum2 += q1Num;
                q2.add(q1Num);
            } else if (sum1 < sum2) {
                int q2Num = q2.poll();
                sum2 -= q2Num;
                sum1 += q2Num;
                q1.add(q2Num);
            }
            
            if (answer >= queue1.length * 3)
                return -1;
            answer++;
        }

        return answer;
    }
}