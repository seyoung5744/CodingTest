import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        
        if(nums.length/2 > set.size()){
            return set.size();
        }
        return nums.length/2;
    }
}