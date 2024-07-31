import java.util.*;

public class Solution {

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                int idx = stack.peek();

                if (numbers[idx] < numbers[i]) {
                    stack.pop();
                    answer[idx] = numbers[i];
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.poll()] = -1;
        }
        
        return answer;
    }
}
