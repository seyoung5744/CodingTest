import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int selectNum = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
            
        return Math.min(selectNum, set.size());
    }
}