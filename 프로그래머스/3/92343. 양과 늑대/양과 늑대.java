import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static int answer = 0;
    public static int solution(int[] info, int[][] edges) {

        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
        }

        List<Integer> willVisit = new ArrayList<>(graph.get(0));
        dfs(0, 0, 1, willVisit, info);

        return answer;
    }

    public static void dfs(int cur, int wolf, int sheep, List<Integer> willVisit, int[] info) {

        if(wolf >= sheep) {
            return;
        }

        for (int i = 0; i < willVisit.size(); i++) {
            int next = willVisit.get(i);

            List<Integer> temp = new ArrayList<>(willVisit);

            temp.remove(Integer.valueOf(next));
            temp.addAll(graph.get(next));

            if(info[next] == 0) {
                dfs(next, wolf, sheep + 1, temp, info);
            } else {
                dfs(next, wolf + 1, sheep, temp, info);
            }
        }

        answer = Math.max(answer, sheep);
    }
}
