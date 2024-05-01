import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> map = new HashMap<>();
        Set<Integer> keySet = new TreeSet<>();

        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0L) + 1);
            keySet.add(weights[i]);
        }

        for (int current : keySet) {

            answer += map.get(current) * (map.get(current) - 1) / 2;

            int three = current * 3;
            if (three % 2 == 0) {
                if (map.containsKey(three / 2)) {
                    answer += map.get(current) * map.get(three / 2);
                }
            }

            int four = current * 4;

            if (map.containsKey(current * 2)) {
                answer += map.get(current) * map.get(current * 2);
            }

            if (four % 3 == 0) {
                if (map.containsKey(four / 3)) {
                    answer += map.get(current) * map.get(four / 3);
                }
            }
        }

        return answer;
    }

}
