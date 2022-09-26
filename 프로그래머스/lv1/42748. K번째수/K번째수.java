import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            int[] copyArray = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
            Arrays.sort(copyArray);
            answer[i] = (copyArray.length != 1)?copyArray[commands[i][2]-1]: copyArray[0];
        }

        return answer;
    }
}