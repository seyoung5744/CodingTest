import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i -= m) {
            answer += calculateApple(i - m + 1, i, score, m);
        }
        return answer;
    }

    private static int calculateApple(int startIdx, int endIdx, int[] score, int m) {
        if(startIdx < 0) return 0;
        
        int min = Integer.MAX_VALUE;
        for (int i = startIdx; i <= endIdx; i++) {
            min = Math.min(min, score[i]);
        }

        return (min * m);
    }
}