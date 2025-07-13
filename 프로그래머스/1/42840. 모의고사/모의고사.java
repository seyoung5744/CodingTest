import java.util.stream.*;

class Solution {
    
    public static final int[][] students = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}        
    };
    
    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int maxScore = -1;
        
        int idx = 0;
        
        for (int i = 0; i < students.length; i++) {
            for (int answer : answers) {
                if (answer == students[i][idx++ % students[i].length]) {
                    corrects[i]++;
                }
            }
            maxScore = Math.max(maxScore, corrects[i]);
            idx = 0;
        }
        
        int max = maxScore;
        return IntStream.range(0, 3)
            .filter(i ->  corrects[i] == max)
            .map(x -> x + 1)
            .toArray();
    }
}