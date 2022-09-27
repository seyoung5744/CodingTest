import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int choiceNum = nums.length/2;
        if(choiceNum > set.size()){
            return set.size();
        }else {
            return choiceNum;
        }
    }
}