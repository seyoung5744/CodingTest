import java.util.*;

class Solution {
    public int[] solution(int n, int s) {        
        int num = s / n;
        int remain = s % n;
        
        if(num < 1) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            answer[i] = num;
        }
        
        if(remain != 0) {
            for(int i = 0; i < remain; i++) {
                answer[n - remain + i]++;
            }
        }
        
        Arrays.sort(answer);
        return answer;
    }
}