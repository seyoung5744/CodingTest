import java.util.*;

class Solution {
    public static final int[][] people = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {
        int[][] scores = new int[3][2];
        
        for (int person = 0; person < 3; person++) {
            int count = 0;
            for (int i = 0; i < answers.length; i++) {
                if (people[person][i % people[person].length] == answers[i])
                    count++;
            }
            scores[person][0] = person + 1;
            scores[person][1] = count;
        }
        
        Arrays.sort(scores, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        
        List<Integer> answer = new ArrayList<>();
        int max = scores[0][1];
        answer.add(scores[0][0]);
        for (int i = 1; i < 3; i++) {
            if (scores[i][1] == max) {
                answer.add(scores[i][0]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}