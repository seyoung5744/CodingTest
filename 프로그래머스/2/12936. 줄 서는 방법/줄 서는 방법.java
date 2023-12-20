import java.util.*;

class Solution {
    public static List<Integer> nums = new ArrayList<>();

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // n 4
        // k 11
        --k;
        int idx = 0;
        int len = n - 1;

        long num = 1L;
        for (int i = 1; i <= len; i++) {
            num *= i;
        }

        while(len > 0) {
            long index = k / num; // 몫
            k = k % num;

            answer[idx++] = nums.get((int) index);
            nums.remove((int) index);
            num /= len;
            len--;
        }

        answer[idx] = nums.get((int) len);
        
        return answer;
    }
}