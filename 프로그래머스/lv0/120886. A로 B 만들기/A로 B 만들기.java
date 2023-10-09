import java.util.*;

public class Solution {

    public static int solution(String before, String after) {
        return toMap(before).equals(toMap(after))? 1 : 0;
    }
    
    public static Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

}
