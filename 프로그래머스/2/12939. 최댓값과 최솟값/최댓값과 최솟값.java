import java.util.*;

class Solution {
    public String solution(String s) {
        int[] nums = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " " + max;
    }
}