import java.util.*;

public class Solution {

    public static int[] solution(String[] gems) {
        int[] answer = {0, 0};
        int minLength = gems.length + 1;

        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        
        while (end < gems.length) {

            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.keySet().size() == kinds.size()) {

                if (map.get(gems[start]) > 1) {
                    map.put(gems[start], map.get(gems[start]) - 1);
                } else {
                    break;
                }
                start++;
            }

            if(map.keySet().size() == kinds.size()) {
                if (minLength > end - start + 1) {
                    answer = new int[]{start + 1, end + 1};
                    minLength = end - start + 1;
                }
            }
            end++;
        }

        return answer;
    }
}
