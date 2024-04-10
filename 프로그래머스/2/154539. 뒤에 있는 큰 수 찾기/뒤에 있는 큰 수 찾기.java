import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Deque<Integer> stack1 = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack1.isEmpty()) {
                int idx = stack1.peek();

                if (numbers[idx] < numbers[i]) {
                    stack1.pop();
                    answer[idx] = numbers[i];
                } else {
                    break;
                }
            }

            stack1.push(i);
        }

        while (!stack1.isEmpty()) {
            answer[stack1.poll()] = -1;
        }
        return answer;
    }

}
