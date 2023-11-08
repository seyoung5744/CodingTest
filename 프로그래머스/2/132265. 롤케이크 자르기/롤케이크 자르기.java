import java.util.*;

public class Solution {
    public static int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            map2.put(topping[i], map2.get(topping[i]) - 1);

            if(map2.get(topping[i]) == 0) {
                map2.remove(topping[i]);
            }
      
            if(map2.keySet().size() == map1.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}
