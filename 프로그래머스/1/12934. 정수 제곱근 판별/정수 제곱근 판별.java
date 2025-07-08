class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 != 0) {
            return -1;
        }
        
        return (long)((sqrt + 1) * (sqrt + 1));
    }
}