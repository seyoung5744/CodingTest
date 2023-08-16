import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {

            for (int i = 0; i < speeds.length; i++) {
                progresses[i] += speeds[i];

                if (progresses[queue.peek()] >= 100) {
                    cnt += 1;
                    queue.poll();
                }
            }

            if(cnt != 0){
                result.add(cnt);
                cnt = 0;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}