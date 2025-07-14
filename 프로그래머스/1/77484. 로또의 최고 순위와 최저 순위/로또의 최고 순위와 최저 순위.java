import java.util.*;
import java.util.stream.*;

class Solution {
    public static final int[] scores = {6, 6, 5, 4, 3, 2, 1};
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int win : win_nums) {
            set.add(win);
        }
        
        for (int lotto : lottos) {
            if (set.contains(lotto)) {
                answer[0]++;
                answer[1]++;
            } else if (lotto == 0) {
                answer[0]++;
            }
        }
        return Arrays.stream(answer)
            .map(i -> scores[i])
            .toArray();
    }
}