import java.util.*;

public class Solution{

    public static boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            switch(c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }


}
