import java.util.*;
class Solution {
    public int solution(int[] nums) {
         int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (int item : list){
            boolean flag = true;
            for (int i = 2; i*i <= item; i++) {
                if(item % i == 0) {
                    flag = false;
                    break; // 소수가 아님
                }
            }

            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
}