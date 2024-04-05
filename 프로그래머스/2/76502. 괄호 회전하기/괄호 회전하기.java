import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {

    public static Map<Character, Character> parenthesis = Map.of('(', ')', '{', '}', '[', ']');

    public static int solution(String s) {
        int answer = 0;
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if(isValid(queue)) {
                answer++;
            }
            
            queue.add(queue.poll());
        }
        return answer;
    }

    public static boolean isValid(Deque<Character> s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> queue = new ArrayDeque<>(s);
        
        while(!queue.isEmpty()) {
            char ch = queue.poll();
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
