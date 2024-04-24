import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < number.length(); ++i) {
            int num = number.charAt(i) - '0';

            if (s.isEmpty()) {
                s.push(num);
            } else {
                while(k > 0 && !s.isEmpty() && num > s.peek())
                {
                    s.pop();
                    k--;
                }

                s.push(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            if (k > 0)
            {
                --k;
                s.pop();
                continue;
            }
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}