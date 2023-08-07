import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int target = commands[i][2] - 1;

            answer[i] = sortedSubArray(from, to, array)[target];
        }
        return answer;
    }

    private int[] sortedSubArray(int start, int end, int[] array) {
        int[] subArray = new int[end - start];
        int idx = 0;
        for (int i = start; i < end; i++) {
            subArray[idx++] = array[i];
        }

        Arrays.sort(subArray);

        return subArray;
    }
}