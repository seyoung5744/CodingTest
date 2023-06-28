import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int fix = commands[i][2];
            int[] nums = new int[end - start + 1];

            int idx = 0;
            for (int j = start; j <= end; j++) {
                nums[idx++] = array[j-1];
            }

            Arrays.sort(nums);
            answer[i] = nums[fix - 1];
        }
        return answer;
    }
}