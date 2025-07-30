import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int curWeight = 0;
        int truckIdx = 0;
        
        while (truckIdx < truck_weights.length) {
            curWeight -=  bridge.poll();
            
            int curTruck = truck_weights[truckIdx];
            
            if (curWeight + curTruck <= weight) {
                bridge.add(curTruck);
                curWeight += curTruck;
                truckIdx++;
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