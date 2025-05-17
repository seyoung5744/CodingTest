import java.util.*;

class Solution {
    private static final Map<Character, Character> perenthesis = Map.of(
        ')','(',
        ']','[',
        '}','{'
    );
    
    public int solution(String s) {
        int answer = 0;
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (isValid(new ArrayDeque<>(queue))) {
                answer++;
            }
            queue.offer(queue.poll());
        }
        
        return answer;
    }
    
    private boolean isValid(Deque<Character> queue) {
        Deque<Character> stack = new ArrayDeque<>();
        
        while(!queue.isEmpty()) {
            char c = queue.poll();
            if (!perenthesis.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (perenthesis.get(c) == stack.peek()) stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}