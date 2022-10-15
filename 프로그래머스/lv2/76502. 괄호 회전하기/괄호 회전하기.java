import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();


        for (char ch : s.toCharArray()) {
            queue.add(ch);
        }

        for (int i = 0; i < queue.size(); i++) {
            if (check(queue)) {
                answer += 1;
            }
            queue.add(queue.poll());
        }
        return answer;
    }
    public static boolean check(Queue<Character> queue) {
        Queue<Character> copyQueue = new LinkedList<>(queue);
        Stack<Character> stack = new Stack<>();
        boolean checkFlag = true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        while (!copyQueue.isEmpty()) {
            char s = copyQueue.poll();
            if(map.containsKey(s)){ // 괄호 열기에 해당하면 stack 에 push
                stack.push(s);
            }else if(map.containsValue(s)){ // 괄호 닫기하면
                if(stack.isEmpty()){ // stack 이 비어있으면 flag = false;
                    checkFlag = false;
                    break;
                }else{
                    char data = stack.pop();
                    if(s != map.get(data)){ // s : 괄호 닫기 중 하나, map.get(data) : 스텍에 있는 괄호 열기 중 하나의 괄호 닫기
                        checkFlag = false;
                        break;
                    }
                }
            }
        }
        return stack.isEmpty() && checkFlag;
    }
}