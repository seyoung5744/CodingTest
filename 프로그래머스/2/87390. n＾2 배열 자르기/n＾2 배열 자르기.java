class Solution {
    public int[] solution(int n, long left, long right) {
       int[] answer = new int[(int) (right - left + 1)];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            if (col <= row) {
                answer[idx++] = (int) row + 1;
            } else {
                answer[idx++] = (int) col + 1;
            }
        }

        return answer;
    }
}