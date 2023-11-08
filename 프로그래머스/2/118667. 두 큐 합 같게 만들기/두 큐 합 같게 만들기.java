import java.util.*;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Deque<Long> q1 = new ArrayDeque<>();
        Deque<Long> q2 = new ArrayDeque<>();

        for(int i = 0; i < queue1.length; i++) {
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
        }

        long sum1 = sum(q1);
        long sum2 = sum(q2);

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                long remove = q1.poll();
                sum1 -= remove;
                sum2 += remove;
                q2.add(remove);
                
            } else {
                long remove = q2.poll();
                sum2 -= remove;
                sum1 += remove;
                q1.add(remove);
            }
            
            answer++;
            
            if(answer > queue1.length * 3){
                return -1;
            }
        
        }

        return answer;
    }

    public static long sum(Deque<Long> arr) {
        long result = 0;
        for(long num : arr){
            result += num;
        }
        return result;
    }
}