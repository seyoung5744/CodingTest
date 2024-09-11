import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        findWeak(dist.length - 1, Arrays.stream(weak).boxed().collect(Collectors.toList()), dist, n);
        return result == Integer.MAX_VALUE? -1 : result;
    }

    public static int result = Integer.MAX_VALUE;

    public static void findWeak(int distIdx, List<Integer> weak, int[] dist, int n) {

        if (weak.size() == 0) {
            if (dist.length - distIdx - 1 < result) {
                result = dist.length - distIdx - 1;
            }
            return;
        }
        
        if (distIdx < 0) {
            return;
        }

        int curDistance = dist[distIdx];
        for (int i = 0; i < weak.size(); i++) {
            int curWeak = weak.get(i);
            int end = (curWeak + curDistance) % n;

            List<Integer> copyWeak = new ArrayList<>(weak);

            for (int j = 0; j < weak.size(); j++) {
                int w = weak.get(j);
                if (end > curWeak) {
                    if (w >= curWeak && w <= end) {
                        copyWeak.remove(Integer.valueOf(w));
                    }
                } else {
                    if (w <= end || w >= curWeak) {
                        copyWeak.remove(Integer.valueOf(w));
                    }
                }
            }

            findWeak(distIdx - 1, copyWeak, dist, n);
        }
    }
}
