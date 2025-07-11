import java.util.*;

class Solution {
    public static final Map<String, Integer> mapping = Map.of(
        "zero", 0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    );
    
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }
            temp += c;
            
            if (mapping.containsKey(temp)) {
                sb.append(mapping.get(temp));
                temp = "";
            }
        }
        return Integer.parseInt(sb.toString());
    }
}