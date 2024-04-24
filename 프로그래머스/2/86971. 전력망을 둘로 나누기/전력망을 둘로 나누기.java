public class Solution {

    public static int[] parent;

    public static int solution(int n, int[][] wires) {
        int answer = n;
        parent = new int[n + 1];

        for (int exclude = 0; exclude < wires.length; exclude++) {
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            for (int j = 0; j < wires.length; j++) {
                if (exclude == j) {
                    continue;
                }

                int x = wires[j][0];
                int y = wires[j][1];
                union(x, y);
            }

            int count = 0;
            for (int i = 1; i < parent.length; i++) {
                if (find(parent[i]) == 1) {
                    ++count;
                } 
            }

            answer = Math.min(answer, Math.abs(n - 2 * count));
        }

        return answer;
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }
}
