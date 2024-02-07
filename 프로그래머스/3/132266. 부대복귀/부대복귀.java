import java.util.*;

public class Solution {

    public static List<List<Integer>> map = new ArrayList<>();
    public static int INF = (int) 1e9;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {

        int[] visited = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
            visited[i] = INF;
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            map.get(from).add(to);
            map.get(to).add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        visited[destination] = 0;

        while(!q.isEmpty())
        {
            int cur = q.poll();

            for (int i = 0; i < map.get(cur).size(); i++) {
                int next = map.get(cur).get(i);

                if (visited[next] <= visited[cur] + 1)
                    continue;

                visited[next] = visited[cur] + 1;
                q.add(next);
            }
        }
        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {

            answer[i] = visited[sources[i]] == INF ? -1 : visited[sources[i]];
        }

        return answer;
    }

}
