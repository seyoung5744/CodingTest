import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution {

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a, b) -> a - b);

        Map<Integer, Integer> map = new HashMap<>();

        for (String op : operations) {
            String[] tokens = op.split(" ");

            if (tokens[0].equals("I")) { // 숫자 삽입
                int num = Integer.parseInt(tokens[1]);
                maxQueue.add(num);
                minQueue.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (Integer.parseInt(tokens[1]) == 1) { //최댓값 삭제
                    if (maxQueue.isEmpty())
                        continue;

                    int max = maxQueue.poll();
                    if(map.get(max) == 0){
                        map.remove(max);
                    }
                    if(map.containsKey(max) && map.get(max) != 0) {
                        map.put(max, map.getOrDefault(max, 0) - 1);
                    }
                } else { // 최솟값 삭제
                    if (minQueue.isEmpty())
                        continue;
                    
                    int min = minQueue.poll();
                    if(map.get(min) == 0) {
                        map.remove(min);
                    }
                    if(map.containsKey(min) && map.get(min) != 0) {
                        map.put(min, map.getOrDefault(min, 0) - 1);
                    }
                }
            }
            if(maxQueue.size() == 0) {
                while(!minQueue.isEmpty()) minQueue.poll();
            }

            if(minQueue.size() == 0) {
                while(!maxQueue.isEmpty()) maxQueue.poll();
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0) {
                if(entry.getKey() < min) {
                    min = entry.getKey();
                }

                if(entry.getKey() > max) {
                    max = entry.getKey();
                }
            }
        }
        if(max == Integer.MIN_VALUE && min == Integer.MAX_VALUE) {
            return new int[]{0, 0};
        }
        return new int[]{max, min};
    }

}
