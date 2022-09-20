class Solution {
    public long solution(long n) {
        double m = (int)Math.pow(n, 0.5);
        return Math.pow(m,2) == n? (long)Math.pow(m+1,2): -1;
    }
}