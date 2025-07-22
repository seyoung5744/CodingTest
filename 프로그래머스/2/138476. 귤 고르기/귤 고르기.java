import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 1 2 2 3 3 4 5 5
        Map<Integer, Integer> count = new HashMap<>();
        for (int orange : tangerine) {
            count.put(orange, count.getOrDefault(orange, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(count.values());
        Collections.sort(values);
        for (int i = values.size() - 1; i >= 0; i--) {
            int value = values.get(i);
            k -= Math.min(k, value);
            answer++;
            if (k <= 0) {
                break;
            }

        }
        return answer;
    }
}