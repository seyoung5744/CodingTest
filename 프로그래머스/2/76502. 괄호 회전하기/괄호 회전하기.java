import java.util.*;

public class Solution {

    public int solution(String s) {
        int answer = 0;
        Deque<Character> queue = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        for (int i = 0; i < queue.size(); i++) {
            if(rotation(queue)) {
                answer += 1;
            }
            queue.add(queue.poll());
        }
        return answer;
    }

    public static boolean rotation(Deque<Character> queue) {
        Deque<Character> copyQueue = new ArrayDeque<>(queue);
        Deque<Character> stack = new ArrayDeque<>();

        boolean isCheck = true;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        while (!copyQueue.isEmpty()) {
            char cur = copyQueue.poll();

            if (map.containsKey(cur)) { // 괄호 열기라면
                stack.push(cur);
            } else if (map.containsValue(cur)) { // 괄호 닫기라면
                if (stack.isEmpty()) { // 비었으므로 false;
                    isCheck = false;
                    break;
                } else {
                    char top = stack.pop();

                    if(cur != map.get(top)) {
                        isCheck = false;
                        break;
                    }
                }
            }

        }

        return stack.isEmpty() && isCheck;
    }
}
