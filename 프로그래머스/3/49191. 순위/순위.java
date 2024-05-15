import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }

        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            winGraph.get(lose).add(win);
            loseGraph.get(win).add(lose);
        }

        for (int start = 1; start < n + 1; start++) {
            int win = countPerson(start, winGraph, new boolean[n + 1]);
            int lose = countPerson(start, loseGraph, new boolean[n + 1]);
            if (win + lose == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static int countPerson(int start, List<List<Integer>> graph, boolean[] visited) {
        int result = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (visited[next]) {
                    continue;
                }

                result += 1;
                q.offer(next);
                visited[next] = true;
            }
        }

        return result;
    }
}
