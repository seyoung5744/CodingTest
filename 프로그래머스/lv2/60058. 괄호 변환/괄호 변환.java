import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        if (p.equals("")) {
            return answer;
        }
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if (check(u)) {
            answer += u + solution(v);
        } else {
            answer += "(";
            answer += solution(v);
            answer += ")";

            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            String newU = "";
            for (int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') newU += ")";
                else newU += "(";
            }
            answer += newU;
        }

        return answer;
    }

    public static int balancedIndex(String p) {
        // 왼쪽 괄호 개수
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            if (count == 0) {
                return i;
            }
        }

        return -1;
    }

    // "올바른 괄호 문자열"인지 판단
    public static boolean check(String p) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}