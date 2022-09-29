import java.util.*;
class Solution {
    public static Map<String, Integer> toHash(String[] participant){
        Map<String, Integer> part = new HashMap<>();
        int count = 1;
        for (String s : participant){
            if(part.containsKey(s)) {
                part.put(s, part.get(s)+ 1);
            }else{
                part.put(s, count);
            }
        }
        return part;
    }
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> part = toHash(participant);

        for (String comp : completion){
            if(part.containsKey(comp)){
                part.put(comp,part.get(comp)-1);
            }
        }

        for (String name : part.keySet()){
            if(part.get(name) == 1){
                answer = name;
                break;
            }
        }
        return answer;
    }    
}