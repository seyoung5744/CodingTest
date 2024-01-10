import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> {
            if(a[0] == b[0]) 
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int end = -30_001;
        
        for(int i = 0; i < routes.length; i++) {
            
            if(end < routes[i][0]) {
                answer++;
                end = routes[i][1];
            } else {
                end = Math.min(end, routes[i][1]);
            }
        }
        return answer;
    }
}