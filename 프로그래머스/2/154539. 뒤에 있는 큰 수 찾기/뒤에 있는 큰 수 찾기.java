import java.util.*;

class Solution {
    public static int[] parents = new int[1_000_001];
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Arrays.fill(parents, -1);
        answer[numbers.length - 1] = -1;
        
        for(int i = numbers.length - 2; i >= 0; i--) {
            
            if(numbers[i] < numbers[i+1]) {
                answer[i] = numbers[i+1];
                parents[numbers[i]] = numbers[i+1];
            } else {
                answer[i] = find(numbers[i+1], numbers[i]);
                parents[numbers[i]] = answer[i];
            }
        }
        
        return answer;
    }
    
    public int find(int x, int origin) {
        
        if(x > origin) {
            return x;
        }
        
        if(x == -1) {
            return -1;
        }
        
        return find(parents[x], origin);
    }
}