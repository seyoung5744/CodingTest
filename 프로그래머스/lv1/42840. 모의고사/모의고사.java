import java.util.*;
import java.util.stream.*;

class Solution {
    private static final int[][] STUDENTS = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    private static int count;

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < STUDENTS.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (STUDENTS[i][j % STUDENTS[i].length] == answers[j]) {
                    count += 1;
                }
            }
            corrects[i] = count;
            max = Math.max(max, count);
            count = 0;
        }

        final int maxCorrect = max;
        return IntStream.range(0, 3)
            .filter(i -> corrects[i] == maxCorrect)
            .map(x -> x + 1)
            .toArray();
    }
}