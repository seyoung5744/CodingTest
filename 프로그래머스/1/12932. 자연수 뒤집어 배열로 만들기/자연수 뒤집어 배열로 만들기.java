class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            long rest = n % 10;
            sb.append(rest);
            n /= 10;
        }

        return sb.chars().map(i -> i - '0').toArray();
    }
}