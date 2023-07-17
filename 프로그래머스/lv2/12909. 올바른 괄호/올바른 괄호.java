import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){

            if(stack.isEmpty() && c == ')') return false;

            if(c == '(') stack.push(c);
            else if(c == ')') stack.pop();
        }
        
        return stack.isEmpty();
    }
}