import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String time : timetable) {
            String[] tokens = time.split(":");
            pq.add((Integer.parseInt(tokens[0]) * 60) + Integer.parseInt(tokens[1]));
        }
        
        int curTime = 9 * 60;
        int last = 0;
        
        for(int i = 0; i < n; i++) {
            int count = 0;    
            
            while(!pq.isEmpty() && pq.peek() <= curTime) {
                last = pq.peek();
                pq.poll();
                count++;
                if(count >= m) {
                    break;
                }
            }
            
            if(i == n - 1) {
                 if(count == m) {
                     last -= 1;
                 }else {
                     last = curTime;
                 }
            }
            curTime += t;
        }
    
        
        answer = String.format("%02d", last/60) + ":" + String.format("%02d", last%60);
        return answer;
    }
}