import java.util.*;

class Solution {
    
    public static Map<Integer, String> map = Map.of(
        0, "1",
        1, "2",
        2, "4"
    );
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n -= 1;
            sb.append(map.get(n % 3));
            n /= 3;
        }
        
        return sb.reverse().toString();
    }
}