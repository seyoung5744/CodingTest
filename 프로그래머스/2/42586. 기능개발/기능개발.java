import java.util.*;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> progress = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = (100 - progresses[i]) % speeds[i];
            if(remain > 0) {
                progress.add((100 - progresses[i]) / speeds[i] + 1);
            }else{
                progress.add((100 - progresses[i]) / speeds[i]);
            }
        }
        
        int max = progress.peek();
        int num = 0;
        while(!progress.isEmpty()) {
            int cur = progress.poll();

            if(max >= cur) {
                num++;
            } else {
                result.add(num);
                num = 1;
            }
            max = Math.max(max, cur);
        }
        result.add(num);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
