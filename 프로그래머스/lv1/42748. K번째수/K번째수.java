import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int target = commands[i][2] - 1;

            int[] subArr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArr);
            answer[i] = subArr[target];
        }
        return answer;
    }

}
