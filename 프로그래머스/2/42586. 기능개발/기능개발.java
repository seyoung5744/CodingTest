import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] completedDays = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            completedDays[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                completedDays[i]++;
            }
        }
        List<Integer> answer = new ArrayList<>();
        int max = completedDays[0];
        int count = 0;
        for (int i = 0; i < completedDays.length; i++) {
            if (completedDays[i] > max) {
                answer.add(count);
                max = Math.max(max, completedDays[i]);
                count = 0;
            } 
            count++;
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}