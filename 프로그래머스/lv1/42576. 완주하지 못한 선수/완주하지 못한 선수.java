import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String name : participant){
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name) + 1);
        }
        
        for(String name : completion){
            map.put(name, map.get(name) - 1);
        }
        
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                return entry.getKey();
            }
        }
        return "";
    }
}