import java.util.*;

public class Solution {

    public static List<List<Integer>> map = new ArrayList<>();

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] counts = bfs(destination, n);
        for (int i = 0; i < sources.length; i++) {
            int idx = sources[i];
            answer[i] = counts[idx] == 100_001 ? -1 : counts[idx];
        }

        return answer;
    }

    public static int[] bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, 100_001);
        q.add(start);
        visited[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < map.get(cur).size(); i++) {
                int next = map.get(cur).get(i);

                if (visited[next] <= visited[cur] + 1) {
                    continue;
                }

                visited[next] = visited[cur] + 1;
                q.add(next);
            }
        }

        return visited;
    }
}
