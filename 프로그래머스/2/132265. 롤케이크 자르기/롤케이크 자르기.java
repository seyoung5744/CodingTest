import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> person1 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            person1.put(topping[i], person1.getOrDefault(topping[i], 0) + 1);
        }

        Map<Integer, Integer> person2 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            person2.put(topping[i], person2.getOrDefault(topping[i], 0) + 1);
            person1.put(topping[i], person1.getOrDefault(topping[i], 0) - 1);
            if(person1.get(topping[i]) == 0) {
                person1.remove(topping[i]);
            }

            if(person2.keySet().size() == person1.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}
