import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int progress : progresses) {
            q.add(progress);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int speedIdx = 0;
        int preDay = (int) Math.ceil((100.0 - q.poll()) / speeds[speedIdx++]);
        int count = 1;
        
        while (!q.isEmpty()) {  
            int progress = q.poll();
            int day = (int) Math.ceil((100.0 - progress) / speeds[speedIdx++]);
            if(day <= preDay) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
            
            preDay = Math.max(day, preDay);
        } 
        list.add(count);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}