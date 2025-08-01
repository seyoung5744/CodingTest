import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] mainBelt = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            mainBelt[i] = i + 1;
        }

        int orderIdx = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < mainBelt.length; i++) {
            stack.push(mainBelt[i]);
            
            while (!stack.isEmpty() && order[orderIdx] == stack.peek()) {
                stack.pop();
                orderIdx++;
                answer++;
            }
        }

        return answer;
    }
}