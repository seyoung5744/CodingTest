import java.util.stream.*;

class Solution {
    public static final int[][] students = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public static int idx, count;

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int i = 0; i < students.length; i++) {
            int length = students[i].length;
            for (int answer : answers) {
                if (answer == students[i][idx++ % length]) {
                    count++;
                }
            }
            corrects[i] = count;
            max = Math.max(max, count);
            idx = 0;
            count = 0;
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
            .filter(x -> corrects[x] == maxCorrects)
            .map(x -> x + 1)
            .toArray();
    }
}