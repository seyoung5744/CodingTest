class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long count1 = 0;
        for (int y = 1; y < r1; y++) {
            double temp = Math.sqrt((double)r1 * r1 - (double)y * y);
            count1 += (int) temp;
            
            if (temp % 1 == 0)
                count1--;
        }
        
        long count2 = 0;
        for (int y = 1; y < r2; y++) {
            int count = (int) Math.sqrt((double)r2 * r2 - (double)y * y);
            count2 += count;
        }
        answer += (count2 - count1) * 4;
        answer += (r2 - r1 + 1) * 4;
        return answer;
    }
}