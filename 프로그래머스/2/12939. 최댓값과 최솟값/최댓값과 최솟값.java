import java.util.*;

public class Solution {

    public static String solution(String s) {
        int[] nums = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(max < nums[i]) max = nums[i];
            if(min > nums[i]) min = nums[i];
        }

        return String.format("%d %d", min, max);
    }

}
