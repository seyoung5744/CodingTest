import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();

        StringBuilder answer = new StringBuilder();
        for(char c : my_string.toCharArray()){
            if(set.contains(c)) continue;
            set.add(c);
            answer.append(c);
        }
        return answer.toString();
    }
}