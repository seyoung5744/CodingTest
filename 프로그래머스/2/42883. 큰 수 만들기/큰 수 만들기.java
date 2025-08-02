import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Integer> stack = new ArrayDeque<>();

        // 4 1 7 7 2 5 2 8 4 1
        for (int i = 0; i < number.length(); i++) {
            int cur = number.charAt(i) - '0';

            if (stack.isEmpty()) {
                stack.push(cur);
            } else {

                while (k > 0 && !stack.isEmpty() && stack.peek() < cur) {
                    stack.pop();
                    k--;
                }
                stack.push(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            if (k > 0) {
                k--;
                stack.pop();
                continue;
            }
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}