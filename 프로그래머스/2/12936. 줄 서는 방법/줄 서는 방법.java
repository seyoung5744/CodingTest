import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        long num = 1;

        for(int i = 1; i < n; ++i)
        {
            num *= i;
        }
        
        --n;
        --k;
        int targetIdx = 0;
        while(!nums.isEmpty())
        {
            int idx = (int)(k / num);
            answer[targetIdx] = nums.get(idx);
            nums.remove(idx);
            k %= num;
            
            if (n == 0)
                break;
            
            num /= n;
            --n;
            ++targetIdx;
        }
        return answer;
    }

}
