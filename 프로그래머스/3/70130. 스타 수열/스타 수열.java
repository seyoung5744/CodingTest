import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int answer = 0;

        for (int key : map.keySet()) {
            if(map.get(key) <= answer)
                continue;
            
            int cnt = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if(a[j] != key && a[j + 1] != key) continue;
                if(a[j] == a[j + 1]) continue;
                cnt++;
                j++;
            }
            answer = Math.max(cnt, answer);
        }

        return answer * 2;
    }
}
