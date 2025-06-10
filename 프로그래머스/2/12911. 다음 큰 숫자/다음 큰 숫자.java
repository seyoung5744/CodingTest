class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);

        int nextCount = 0;
        int next = n + 1;
        while (count != nextCount) {
            nextCount = Integer.bitCount(next);
            next++;
        }
        return next - 1;
    }
}