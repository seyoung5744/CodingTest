import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int curBridgeWeight = 0; // 현재 다리 무게
        int truckIdx = 0;
        int time = 0;

        while (truckIdx < truck_weights.length) {
            curBridgeWeight -= bridge.poll(); // 현재 다리 무게

            int truckWeight = truck_weights[truckIdx]; // 순서 트럭

            if (curBridgeWeight + truckWeight <= weight) { // 현재 다리 무게 + 현재 트럭 무게 <= 초과
                bridge.add(truckWeight);
                truckIdx += 1;
                curBridgeWeight += truckWeight;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while (!bridge.isEmpty()) {
            time++;
            bridge.poll();
        }

        return time;
    }
}
