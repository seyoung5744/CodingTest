import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> person1 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            person1.put(topping[i], person1.getOrDefault(topping[i], 0) + 1);
        }
        
        Map<Integer, Integer> person2 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            person2.put(topping[i], person2.getOrDefault(topping[i], 0) + 1);
            
            int toppingCount = person1.get(topping[i]) - 1;
            person1.put(topping[i], toppingCount);
            if (toppingCount == 0) {
                person1.remove(topping[i]);
            }
            if (person1.size() == person2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}