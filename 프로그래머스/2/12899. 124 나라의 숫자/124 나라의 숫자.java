import java.util.*;

class Solution {
     public static Map<Integer, Character> radix = new HashMap<>() {{
        put(0, '1');
        put(1, '2');
        put(2, '4');
    }};

    public static String solution(int n) {
        String answer = "";

        while (n > 0) {
    
            n--;
            answer = radix.get(n % 3) + answer;
            n /= 3;
         
        }
        return answer;
    }
}