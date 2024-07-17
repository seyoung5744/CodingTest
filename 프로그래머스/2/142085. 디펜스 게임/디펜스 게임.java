import java.util.PriorityQueue;

public class Solution {

    public static int solution(int n, int k, int[] enemies) {
        int round = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int enemy : enemies) {
            // 일단 싸워
            n = n - enemy;
            pq.add(enemy);

            if (n < 0) {
                if (k <= 0) {
                    break;
                }

                n += pq.poll();
                k--;
            }

            round += 1;
        }

        return round;
    }
}
