import java.util.*;

class Solution {
    public static final String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alphabets[i], i + "");
        }
        return Integer.parseInt(s);
    }
}