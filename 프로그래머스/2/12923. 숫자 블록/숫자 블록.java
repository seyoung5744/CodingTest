class Solution {
    public int[] solution(long begin, long end) {
        long size = end - begin + 1;
        int[] answer = new int[(int) size];

        for (long i = begin; i <= end; i++) {
            if (i == 1)
            {
                answer[0] = 0;
                continue;
            }
            for (int j = (int)Math.sqrt(i); j > 0; --j) {
                
                if (i % j == 0) {
                    if (j == 1)
                    {
                        answer[(int)(i - begin)] = Math.max(answer[(int)(i - begin)], 1);
                        break;
                    }
                    
                    if (i / j > 10000000)
                    {
                        answer[(int)(i - begin)] = Math.max(answer[(int)(i - begin)], j);
                        continue;
                    }
                    
                    
                    answer[(int)(i - begin)] = (int)i / j;
                }
            }
        }
        
        return answer;
    }
}