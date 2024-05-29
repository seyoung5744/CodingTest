
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static int[] solution(String[] gems) {
        int[] answer = {0 ,0};
        int minLength = gems.length + 1;

        final Set<String> kinds = new HashSet<>();
        kinds.addAll(Arrays.asList(gems));

        Map<String, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        while (end < gems.length) {

            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            if (map.size() < kinds.size())
            {
                ++end;
                continue;
            }

            while (true) {
                if (map.get(gems[start]) > 1) {
                    map.put(gems[start], map.get(gems[start]) - 1);
                    start++;
                }
                else
                {
                    break;
                }
            }

            if(minLength > end - start + 1)
            {
                minLength = end - start + 1;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
            ++end;
        }

        return answer;
    }

}
