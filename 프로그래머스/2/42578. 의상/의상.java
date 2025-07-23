import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothCount = new HashMap<>();
        
        for (String[] cloth : clothes) {
            clothCount.put(cloth[1], clothCount.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        List<Integer> count = new ArrayList<>(clothCount.values());
        for (int c : count) {
            answer *= (c + 1);
        }
        
        return answer - 1;
    }
}