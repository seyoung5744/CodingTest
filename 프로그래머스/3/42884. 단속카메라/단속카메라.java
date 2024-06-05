import java.util.Arrays;

public class Solution {

    public static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);

        int end = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            int nextStart = routes[i][0];
            int nextEnd = routes[i][1];

            if(nextStart <= end) {
                end = Math.min(end, nextEnd);
            } else {
               end = nextEnd;
               answer++;
            }
        }
        return answer;
    }
}
