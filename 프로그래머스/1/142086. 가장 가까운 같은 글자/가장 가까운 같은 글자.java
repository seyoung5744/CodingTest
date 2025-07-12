import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (pos[idx] == -1) {
                answer[i] = pos[idx];
            } else {
                answer[i] = i - pos[idx];                
            }
            pos[idx] = i;
        }
        
        return answer;
    }
}