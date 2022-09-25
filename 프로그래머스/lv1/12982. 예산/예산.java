import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length+1; i++) {
            sum = 0;
            for (int j = 0; j < i; j++) {
                sum += d[j];
            }
            if(budget >= sum){
                answer = i;
            }
        }

        return answer;
    }
}