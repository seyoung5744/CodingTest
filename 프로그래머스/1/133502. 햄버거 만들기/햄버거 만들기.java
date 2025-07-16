import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int ingre : ingredient) {
            stack.push(ingre);

            if (stack.size() > 3 && stack.peek() == 1) {
                int o = stack.pop();
                int i = stack.pop();
                int j = stack.pop();
                int k = stack.pop();
                if (o == 1 && i == 3 && j == 2 && k == 1) {
                    answer++;
                } else {
                    stack.push(k);
                    stack.push(j);
                    stack.push(i);
                    stack.push(o);
                }
            }
        }
        return answer;
    }
}