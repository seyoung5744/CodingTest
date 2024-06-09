
import java.util.*;
import java.util.Map.Entry;

public class Solution {

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a, b) -> a - b);

        Map<Integer, Integer> map = new HashMap<>();

        for (String op : operations) {
            String[] tokens = op.split(" ");

            if (tokens[0].equals("I")) { 
                int num = Integer.parseInt(tokens[1]);
                maxQueue.add(num);
                minQueue.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (Integer.parseInt(tokens[1]) == 1) { 
                    if (maxQueue.isEmpty())
                        continue;

                    int max = maxQueue.poll();

                    if(map.containsKey(max) && map.get(max) != 0) {
                        map.put(max, map.getOrDefault(max, 0) - 1);
                    }

                    if(map.get(max) == 0){
                        map.remove(max);
                    }
                } else { 
                    if (minQueue.isEmpty())
                        continue;

                    int min = minQueue.poll();

                    if(map.containsKey(min) && map.get(min) != 0) {
                        map.put(min, map.getOrDefault(min, 0) - 1);
                    }

                    if(map.get(min) == 0) {
                        map.remove(min);
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

        if(map.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey() < min) {
                min = entry.getKey();
            }

            if(entry.getKey() > max) {
                max = entry.getKey();
            }
        }

        return new int[]{max, min};
    }

}
