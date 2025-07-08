class Solution {
    public long solution(int a, int b) {
        return ((Math.abs(a - b) + 1) * (long)(a + b)) / 2;
    }
}