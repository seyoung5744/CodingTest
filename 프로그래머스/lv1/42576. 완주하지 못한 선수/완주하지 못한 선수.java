import java.util.*;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String participate : participant) {
            map.put(participate, map.getOrDefault(participate, 0) + 1);
        }

        for(String complete : completion) {
            if(map.containsKey(complete)) {
                map.put(complete, map.get(complete) - 1);
                if(map.get(complete) == 0){
                    map.remove(complete);
                }
            }
        }

        return map.keySet().toArray(String[]::new)[0];
    }
}