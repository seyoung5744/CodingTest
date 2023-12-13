import java.util.*;

class Solution {
    
    public static String[] nums = {"1", "2", "4"};
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n -= 1;
            sb.append(nums[n % 3]);
            n /= 3;
        }
        
        return sb.reverse().toString();
    }
}