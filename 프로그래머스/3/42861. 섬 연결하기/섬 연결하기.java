import java.util.Arrays;

public class Solution {

    public static int[] parents;

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for(int[] c : costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];

           if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }

            int root = parents[0];
            boolean flag = true;
            for (int i = 1; i < parents.length; i++) {
                if(root != parents[i]) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                return answer;
            }

        }
        return answer;
    }


    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent < bParent) {
            parents[bParent] = aParent;

        } else {
            parents[aParent] = bParent;
        }
        find(b);
        find(a);
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}
