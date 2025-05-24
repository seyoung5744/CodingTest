import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            visited[i] = Integer.MAX_VALUE;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int count = 0;
        int maxDis = 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[cur] > maxDis) {
                maxDis = visited[cur];
                count = 1;
            } else if (visited[cur] == maxDis) {
                count++;
            }

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (visited[cur] + 1 >= visited[next]) continue;

                visited[next] = visited[cur] + 1;
                q.add(next);
            }
        }
        return count;
    }
}