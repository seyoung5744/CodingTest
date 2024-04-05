import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        int[] completeDays = new int[speeds.length];

        for (int i = 0; i < speeds.length; i++) {
            completeDays[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                ++completeDays[i];
        }

        List<Integer> answer = new ArrayList<>();

        int max = completeDays[0];
        int count = 1;

        for (int i = 1; i < completeDays.length; i++) {
            if (completeDays[i] > max) {
                answer.add(count);
                max = completeDays[i];
                count = 1;
            } else {
                count++;
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
