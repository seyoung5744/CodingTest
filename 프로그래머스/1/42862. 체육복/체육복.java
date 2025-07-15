import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i < lost.length) {
                nums[lost[i] - 1] -= 1;    
            }
            if (i < reserve.length) {
                nums[reserve[i] - 1] += 1;     
            }
            nums[i] += 1;
        }
        
        for (int i = 0; i < lost.length; i++) {
            int idx = lost[i] - 1;
            
            if (idx > 0 && nums[idx - 1] > 1) {
                nums[idx - 1] -= 1;
                nums[idx] = 1;
            } else if (idx < n - 1 && nums[idx + 1] > 1) {
                nums[idx + 1] -= 1;
                nums[idx] = 1;
            }
            
        }
        return (int) Arrays.stream(nums)
            .filter(i -> i > 0)
            .count();
    }
}