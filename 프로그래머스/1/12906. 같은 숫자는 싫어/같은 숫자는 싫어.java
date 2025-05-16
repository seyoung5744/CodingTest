import java.util.*;

public class Solution {
    public int[] solution(int []arr) {       
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int num : arr) {
            if(stack.isEmpty()) {
                stack.push(num);
                continue;
            } 
            
            if(stack.peek() == num) continue;
            stack.push(num);
        }

        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        while(!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }
        return answer;
    }
}