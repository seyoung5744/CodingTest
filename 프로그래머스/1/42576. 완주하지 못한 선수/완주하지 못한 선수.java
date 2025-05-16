import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> notCompletion = new HashMap<>();
        for(String part : participant) {
            notCompletion.put(part, notCompletion.getOrDefault(part, 0) + 1);
        }
        for(String com : completion) {
            int count = notCompletion.get(com) - 1;
            if(count == 0) {
                notCompletion.remove(com);
            } else {
                notCompletion.put(com, count);
            }
        }
        Set<String> remain = notCompletion.keySet();
        for (String person : remain) {
            answer = person;
        }
        return answer;
    }
}