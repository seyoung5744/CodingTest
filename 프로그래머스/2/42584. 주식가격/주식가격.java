import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.pop();
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (prices.length - 1) - idx;
        }
        return answer;
    }

}
