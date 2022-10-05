class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            double x = (double)n/i - ((double)i/2) + 0.5;

            if ((x == Math.floor(x)) && x > 0) {
                answer++;
            }
        }

        return answer;
    }
}