import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Deque<Integer> del = new ArrayDeque<>();
        Deque<Integer> pick = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (deliveries[i] > 0) {
                del.push(i);
            }

            if (pickups[i] > 0) {
                pick.push(i);
            }
        }


        while (!del.isEmpty() || !pick.isEmpty()) {

            int delCount = cap;
            int pickCount = cap;

            long max  = 0;

            while(!del.isEmpty() && delCount > 0) {
                int dIdx = del.peek();

                if (dIdx > max)
                    max = dIdx;

                if (delCount >= deliveries[dIdx])
                {
                    delCount -= deliveries[dIdx];
                    del.pop();
                }
                else
                {
                    deliveries[dIdx] -= delCount;
                    break;
                }
            }

            while(!pick.isEmpty() && pickCount > 0) {
                int pIdx = pick.peek();

                if (pIdx > max)
                    max = pIdx;

                if (pickCount >= pickups[pIdx])
                {
                    pickCount -= pickups[pIdx];
                    pick.pop();
                }
                else
                {
                    pickups[pIdx] -= pickCount;
                    break;
                }
            }

            answer += (max + 1) * 2L;
        }

        return answer;
    }
}
