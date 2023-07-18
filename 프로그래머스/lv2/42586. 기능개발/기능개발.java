import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> process = new ArrayDeque<>();
        for(int progress : progresses){
            process.add(progress);
        }

        int start = 0;
        while(!process.isEmpty()){
            int cnt = 0;

            if(process.peek() >= 100) {
                while (!process.isEmpty() && process.peek() >= 100) {
                    cnt++;
                    process.poll();
                    start++;
                }
                result.add(cnt);
            }
            for (int i = start; i < speeds.length; i++) {
                int progress = process.poll() + speeds[i];
                process.add(progress);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}