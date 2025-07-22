import java.util.*;

class Solution {
    
    public static final Map<Character, Character> parenthesis = Map.of('(', ')', '{', '}', '[', ']');

    public int solution(String s) {
        int answer = 0;

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            deque.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            if (isValid(deque)) {
                answer++;
            }
            deque.add(deque.poll());
        }
        return answer;
    }

    private boolean isValid(Deque<Character> deque) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> queue = new ArrayDeque<>(deque);

        while (!queue.isEmpty()) {
            char cur = queue.poll();

            if (parenthesis.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (parenthesis.get(stack.peek()) != cur) {
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