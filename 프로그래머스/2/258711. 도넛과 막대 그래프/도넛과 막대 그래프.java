import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static final int MAX_EDGES_LENGTH = 1_000_001;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_EDGES_LENGTH];
    public static boolean[] isRoot = new boolean[MAX_EDGES_LENGTH];

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        for (int i = 0; i < MAX_EDGES_LENGTH; i++) {
            graph.add(new ArrayList<>());
            isRoot[i] = true;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            isRoot[to] = false;
        }

        int root = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (isRoot[i] && graph.get(i).size() >= 2) {
                root = i;
                break;
            }
        }
        answer[0] = root;

        int line = 0;
        int circle = 0;
        int eight = 0;
        for (int i = 0; i < graph.get(root).size(); ++i) {
            int cur = graph.get(root).get(i);
            visited[cur] = true;
            while (true) {
                if (graph.get(cur).isEmpty()) {
                    // 막대
                    line += 1;
                    break;
                }

                if (graph.get(cur).size() > 1) {
                    // 팔자
                    eight += 1;
                    break;
                }

                cur = graph.get(cur).get(0);
                if (visited[cur]) {
                    // 도넛
                    circle += 1;
                    break;
                }
                visited[cur] = true;
            }

        }
        answer[1] = circle;
        answer[2] = line;
        answer[3] = eight;
        return answer;
    }
}
