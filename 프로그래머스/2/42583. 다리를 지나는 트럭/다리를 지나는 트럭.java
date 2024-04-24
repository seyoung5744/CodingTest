import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int idx = 0;
        int curBridgeWeight = 0;
        int time = 0;

        while (idx < truck_weights.length) {

            curBridgeWeight -= bridge.poll();

            int curTruck = truck_weights[idx];

            if (curBridgeWeight + curTruck <= weight) {
                bridge.add(curTruck);
                curBridgeWeight += curTruck;
                idx++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while (!bridge.isEmpty()) {
            bridge.poll();
            time++;
        }
        return time;
    }

}
