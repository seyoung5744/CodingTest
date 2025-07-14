class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int end = 0;
        for (int sec : section) {
            if (end >= sec) continue;
            else {
                end = sec + m - 1;
                answer++;
            }

            if (end >= n) break;
        }
        return answer;
    }
}