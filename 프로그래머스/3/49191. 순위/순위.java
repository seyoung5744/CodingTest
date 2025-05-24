import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }

        for (int[] edge : results) {
            int win = edge[0];
            int lose = edge[1];

            winGraph.get(lose).add(win);
            loseGraph.get(win).add(lose);
        }

        for (int i = 1; i <= n; i++) {
            int winCount = getCount(winGraph, i);
            int loseCount = getCount(loseGraph, i);
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    public int getCount(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (visited[next]) continue;

                count++;
                visited[next] = true;
                q.add(next);
            }
        }

        return count;
    }

}