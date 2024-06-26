import java.util.Arrays;

public class Solution {

    public static final int INF = 200000000;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 200000000;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int[] road : fares) {
            int from = road[0];
            int to = road[1];
            int cost = road[2];
            graph[from][to] = cost;
            graph[to][from] = cost;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, graph[s][i] + graph[a][i] + graph[b][i]);
        }

        return answer;
    }
}
