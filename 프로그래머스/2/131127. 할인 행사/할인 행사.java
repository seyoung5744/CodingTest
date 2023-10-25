import java.util.*;

public class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int start = 0;
        int end = 0;

        Map<String, Integer> discountMap = new HashMap<>();

        while(start <= discount.length - 10) {

            if (end - start < 10) {
                discountMap.put(discount[end], discountMap.getOrDefault(discount[end], 0) + 1);
                ++end;
            } else {
                if(wantMap.equals(discountMap)) {
                    System.out.println(start);
                    answer++;
                }

                discountMap.put(discount[start], discountMap.get(discount[start]) - 1);
                if(discountMap.get(discount[start]) == 0) {
                    discountMap.remove(discount[start]);
                }
                ++start;
            }
            
        }
        return answer;
    }

}
