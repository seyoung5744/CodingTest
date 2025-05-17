import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        
        for (char p : s.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    char top = stack.pop();
                    if (top == ')') {
                        answer = false;
                        break;
                    }
                }
            }
        }
        return stack.isEmpty() && answer;
    }
}