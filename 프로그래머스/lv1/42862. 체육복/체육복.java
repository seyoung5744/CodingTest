import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0; 
        int[] student = new int[n];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < n; i++) {
            if( i < reserve.length ){
                student[reserve[i]-1] += 1;
            }
            if(i < lost.length ){
                student[lost[i]-1] -= 1;
            }
            student[i] += 1;
        }

        for(int lo : lost){
            int idx = lo-1;
            if(idx-1 > -1 && student[idx-1] > 1){
                student[idx]=1;
                student[idx-1] -= 1;
            }else if(idx+1 < n && student[idx+1] > 1){
                student[idx] = 1;
                student[idx+1] -= 1;
            }
        }
        for(int s : student){
            if(s != 0){
                answer++;
            }
        }
        return answer;
    }
}