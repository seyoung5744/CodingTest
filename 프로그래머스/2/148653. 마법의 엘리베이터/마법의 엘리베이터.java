class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int one = storey % 10;
            storey /= 10;
            
            if(one < 5) {
                answer += one;
                
            }else if(one == 5) {
                int ten = storey % 10;
                
                if (ten < 5)
                {
                    answer += one;
                }
                else
                {
                     answer += 10 - one;
                    ++storey;
                }
                
            }else {
                answer += 10 - one;
                ++storey;
            }
        }
        
        return answer;
    }
}