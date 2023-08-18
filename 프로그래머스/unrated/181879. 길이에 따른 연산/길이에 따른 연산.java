import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 1;
        int length = num_list.length;

        if(length >= 11){
            answer = Arrays.stream(num_list).sum();
        }else{
            for (int i = 0; i < length; i++) {
                answer *= num_list[i];
            }
        }
        return answer;
    }
}