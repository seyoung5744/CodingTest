import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int tang : tangerine) {
            countMap.put(tang, countMap.getOrDefault(tang, 0) + 1);
        }
        List<Integer> values = countMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(int value : values) {
            if(k <= 0)
                break;

            answer++;
            k -= value;
        }
        return answer;
    }
}