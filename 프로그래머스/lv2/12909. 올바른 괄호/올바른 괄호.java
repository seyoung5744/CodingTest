import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == ')') {
                    return false;
                } else {
                    stack.push(c);
                }
            } else {
                if (c == '(') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}