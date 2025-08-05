class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {

            int remain = storey % 10;

            if (remain < 5) {
                answer += remain;
                storey /= 10;
            } else {
                answer += 10 - remain;
                storey /= 10;
                
                if (remain == 5) {
                    if (storey % 10 >= 5) {
                        storey += 1;    
                    }
                } else {
                     storey += 1;  
                }
                
                
            }
        }
        return answer;
    }
}