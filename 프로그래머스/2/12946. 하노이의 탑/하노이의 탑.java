import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(n, 1, 3, 2, answer);
        return answer.stream()
                .toArray(int[][]::new);
    }

    private void hanoi(int num, int start, int end, int mid, List<int[]> answer) {
        if (num == 0)
            return;

        hanoi(num - 1, start, mid, end, answer);
        answer.add(new int[]{start, end});
        hanoi(num - 1, mid, end, start, answer);
    }
}