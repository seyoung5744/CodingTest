import java.util.*;
import java.util.stream.*;

class Solution {
    
    static class Process {
        int location;
        int priority;
        
        public Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    

    public int solution(int[] priorities, int location) {        
        Queue<Process> processes = new ArrayDeque<>();
        List<Integer> all = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            processes.add(new Process(i, priorities[i]));
            all.add(priorities[i]);
        }
        
        Collections.sort(all, Collections.reverseOrder());
        int index = 0;
        int count = 1;
        while(!processes.isEmpty()) {
            Process cur = processes.poll();
            
            if(cur.priority == all.get(index)) {
                if (cur.location == location)
                    break;
                count++;
                index++;
                // ++count;
                // ++index;
            } else {
                processes.add(cur);
            }
            
        }
        
        return count;
    }
}