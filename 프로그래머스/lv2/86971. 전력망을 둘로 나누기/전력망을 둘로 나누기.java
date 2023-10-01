public class Solution {

    public static int[] parent;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        parent = new int[n + 1];

        for (int i = 0; i < wires.length; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < wires.length; j++) {
                if (j == i) {
                    continue;
                }

                int a = wires[j][0];
                int b = wires[j][1];

                unionParent(a, b);
            }

            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(findParent(parent[j]) == 1) count++;
            }

            answer = Math.min(answer, Math.abs(n - 2 * count));
        }

        return answer;
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    private static int findParent(int a) {
        if (a != parent[a]) {
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }

}
