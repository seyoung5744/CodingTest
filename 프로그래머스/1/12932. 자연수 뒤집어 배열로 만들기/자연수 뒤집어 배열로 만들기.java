class Solution {
    public int[] solution(long n) {
        int digits = (int) Math.log10(n) + 1;
        int[] answer = new int[digits];
        
        int idx = 0;
        while (n > 0) {
            answer[idx] = (int)(n % 10);
            n /= 10;
            idx++;
        }
        return answer;
    }
}