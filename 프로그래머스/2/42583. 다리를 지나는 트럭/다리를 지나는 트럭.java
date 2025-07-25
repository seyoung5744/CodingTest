import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        int bridgeWeight = 0;

        while (truckIndex < truck_weights.length) {

            bridgeWeight -= bridge.poll();
            int truckWeight = truck_weights[truckIndex];

            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while(!bridge.isEmpty()) {
            bridge.poll();
            time++;
        }

        return time;
    }
}