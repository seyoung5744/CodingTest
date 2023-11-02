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
                parents[i] = i+1;
            } else {
                int p = parents[i+1];
                answer[i] = -1;
                while(p != -1)
                {
                    if (numbers[p] > numbers[i])
                    {
                        answer[i] = numbers[p];
                        parents[i] = p;
                        break;
                    }
                    
                    p = parents[p];
                }
            }
        }
        
        return answer;
    }
    
}