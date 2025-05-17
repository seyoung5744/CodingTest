import java.util.*;

class Solution {
    private static final Map<Character, Character> perenthesis = Map.of(
        ')','(',
        ']','[',
        '}','{'
    );
    
    public int solution(String s) {
        int answer = 0;
        
        char[] str = s.toCharArray();
        for (int offset = 0; offset < str.length; offset++) {
            if (isValid(str, offset)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValid(char[] str, int offset) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < str.length; i++) {
            char c = str[(i + offset) % str.length];
            if (!perenthesis.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (perenthesis.get(c) != stack.pop()) return false;
            }
        }
        
        return stack.isEmpty();
    }
}