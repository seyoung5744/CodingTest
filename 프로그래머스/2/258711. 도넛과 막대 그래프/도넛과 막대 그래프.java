import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public final static int MAX_NODES = 1_000_000;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_NODES];
    public static int root;

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        for (int i = 0; i <= MAX_NODES; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            visited[to] = true;
        }

        for (int i = 1; i <= MAX_NODES; i++) {
            if(graph.get(i).size() >= 2 && !visited[i]) {
                root = i;
                break;
            }
        }
        
        answer[0] = root;
        Arrays.fill(visited, false);

        for (int i = 0; i < graph.get(root).size(); i++) {
            int cur = graph.get(root).get(i);


            while(true) {
                visited[cur] = true;
                if (graph.get(cur).size() == 2)
                {
                    // 8자
                    answer[3]++;
                    break;
                } else if (graph.get(cur).size() == 0) {
                    // 1자
                    answer[2]++;
                    break;
                } else if( graph.get(cur).size() == 1) {
                    // 다음으로 이동
                    int next = graph.get(cur).get(0);

                    if(visited[next]) {
                        // 삼각형
                        answer[1]++;
                        break;
                    } else {
                        cur = next;
                    }
                }
            }
        }
        return answer;
    }

}
