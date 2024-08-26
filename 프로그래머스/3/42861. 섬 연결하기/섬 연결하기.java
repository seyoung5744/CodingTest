import java.util.*;

public class Solution {

    public static int[] parents;

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }
        }
        return answer;
    }


    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}
