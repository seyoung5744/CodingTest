import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {

    public static Map<Character, Character> parenthesis = Map.of('(', ')', '{', '}', '[', ']');

    public static int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, s.length()) + s.substring(0, i);
            if(isValid(temp)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (parenthesis.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (parenthesis.get(stack.peek()) != ch) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }

}
