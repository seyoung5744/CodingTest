class Solution {
    public long solution(long a, long b) {
        long min = Math.min(a, b);
        long max = Math.max(b, a);

        return (max - min + 1) * (min + max) /2;
    }
    
}