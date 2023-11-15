import java.util.Arrays;

public class Solution {

    public static int INF = 20_000_001;
    public static int[][] graph;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j)
                    graph[i][j] = 0;
            }
        }
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];

            graph[start][end] = cost;
            graph[end][start] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(graph[s][i] + graph[i][a] + graph[i][b], answer);
        }

        return answer;
    }

}
