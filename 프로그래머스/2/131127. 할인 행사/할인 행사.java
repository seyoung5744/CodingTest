import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantedCount = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantedCount.put(want[i], number[i]);
        }

        Map<String, Integer> discountCount = new HashMap<>();
        
        int answer = 0;
        int right = 0;
        for (int left = 0; left <= discount.length - 10; left++) {

            while(right - left < 10) {
                discountCount.put(discount[right], discountCount.getOrDefault(discount[right], 0) + 1);
                right++;
            }
            if (discountCount.equals(wantedCount)) {
                answer++;
            }

            int cnt = discountCount.get(discount[left]) - 1;
            if (cnt <= 0) {
                discountCount.remove(discount[left]);
            } else {
                discountCount.put(discount[left], cnt);
            }
        }
        return answer;
    }
}