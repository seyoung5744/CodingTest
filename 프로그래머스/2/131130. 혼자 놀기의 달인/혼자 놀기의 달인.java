import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static int[] parent;

    public static int solution(int[] cards) {
        parent = new int[cards.length + 1];
        for (int i = 0; i <= cards.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < cards.length; i++) {
            int a = cards[i];

            if(find(i+1) != find(a)) {
                union(i+1, a);
            }
        }

        for (int i = 0; i < parent.length; i++) {
            find(i);
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i < parent.length; i++) {
            map.put(parent[i], map.getOrDefault(parent[i], 0) + 1);
        }

        if(map.size() == 1) {
            return 0;
        }

        int[] nums = map.values().stream().mapToInt(Integer::intValue).sorted().toArray();
        return nums[nums.length-2] * nums[nums.length-1];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

}
