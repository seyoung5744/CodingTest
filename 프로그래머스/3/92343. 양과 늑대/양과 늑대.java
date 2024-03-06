import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<List<Integer>> graph = new ArrayList<>();
    public static int answer = 0;
    public static int solution(int[] info, int[][] edges) {

        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }

        dfs(0, 0, 0, new ArrayList<>(), info);
        return answer;
    }

    private static void dfs(int cur, int sheep, int wolf, List<Integer> visited, int[] info) {
        if(info[cur] == 0) { // 양
            sheep++;
        } else {
            wolf++;
        }

        if(wolf >= sheep) return;

        answer = Math.max(sheep, answer);
        visited.addAll(graph.get(cur)); // 방문 노드의 자식들 넣기

        for (int i = 0; i < visited.size(); i++) {
            int next = visited.get(i); // 다음 노드
            List<Integer> nextList = new ArrayList<>(visited);
            nextList.remove(i);
            dfs(next, sheep, wolf, nextList, info);
        }
    }

}
