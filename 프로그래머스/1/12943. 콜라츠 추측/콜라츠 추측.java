class Solution {
    public int solution(int num) {
        if (num == 1) return 0;
        
        int count = 0;
        long n = num;
        while (n != 1) {
            if (count >= 500) {
                return -1;
            }
            
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            count++;
        }
        return count;
    }
}