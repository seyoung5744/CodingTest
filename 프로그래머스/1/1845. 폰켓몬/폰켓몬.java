import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int selectNum = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
            
        return Math.min(selectNum, map.keySet().size());
    }
}