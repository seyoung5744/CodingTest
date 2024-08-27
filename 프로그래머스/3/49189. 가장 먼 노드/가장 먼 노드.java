import java.util.*;

public class Solution {

    public static List<List<Integer>> graph = new ArrayList<>();

    public static int solution(int n, int[][] edges) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int start = 1;
        int[] visited = bfs(start, n);
        int max = Arrays.stream(visited).max().getAsInt();
        
        return (int) Arrays.stream(visited)
            .filter(value -> value == max)
            .count();
    }

    public static int[] bfs(int start, int n) {
        int[] visited = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (visited[next] == 0 || visited[next] > visited[cur] + 1) {
                    visited[next] += visited[cur] + 1;
                    q.add(next);
                }
            }
        }

        return visited;
    }
}
