import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name) + 1);
        }

        for (String name : completion) {
            int value = map.get(name) - 1;
            map.put(name, value);
            if(value == 0) map.remove(name);
        }
        
        return map.keySet().iterator().next();
    }

}
