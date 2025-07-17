import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] tokens = term.split(" ");
            termsMap.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        
        List<Integer> result = new ArrayList<>();
        
        int todayInt = convert(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] tokens = privacies[i].split(" ");
            int plusMonth = termsMap.get(tokens[1]);
            int privacy = convert(tokens[0]) + (plusMonth * 28);
            
            if (privacy <= todayInt) {
                result.add(i + 1);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int convert(String date) {
        String[] tokens = date.split("\\.");
        
        int year = (Integer.parseInt(tokens[0]) - 2000) * (12 * 28);
        int month = (Integer.parseInt(tokens[1]) - 1) * 28;
        int day = Integer.parseInt(tokens[2]);
        return year + month + day;
    }
}