import java.util.PriorityQueue;

public class Solution {

    public static int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> y - x);

        for (int round = 0; round < enemy.length; round++) {
            n -= enemy[round];
            pq.offer(enemy[round]);

            if(n < 0) {
                if (k <= 0){
                    answer = round;
                    break;
                }

                n += pq.poll();
                k--;
            }
        }

        return answer;
    }

}
