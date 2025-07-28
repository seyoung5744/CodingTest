import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                int idx = stack.peek();
                
                if (numbers[idx] < numbers[i]) {
                    answer[idx] = numbers[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}