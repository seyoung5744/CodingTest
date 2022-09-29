import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> set = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    set.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int item : set){
            boolean flag = true;
            for (int i = 2; i*i <= item; i++) {
                if(item % i == 0) {
                    flag = false;
                    break; // 소수가 아님
                }
                flag = true;
            }

            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
}