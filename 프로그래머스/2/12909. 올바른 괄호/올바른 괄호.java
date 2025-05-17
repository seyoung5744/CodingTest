import java.util.*;

class Solution {
    boolean solution(String s) {
        int counter = 0;
        
        for (char p : s.toCharArray()) {
            if (p == '(') {
                counter++;
            } else {
                if (counter == 0) return false;
                counter--;
            }
        }
        return counter == 0;
    }
}