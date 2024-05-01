import java.util.Arrays;

public class Solution {


    public static int[][] graph;

    public static int solution(int N, int[][] roads, int K) {
        int answer = 1;

        graph = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], 1000000);
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int cost = road[2];

            if (cost > K)
                continue;

            graph[a][b] = Math.min(graph[a][b], cost);
            graph[b][a] = Math.min(graph[b][a], cost);
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }


        for (int a = 2; a <= N; a++) {
            if (graph[1][a] <= K) {
                answer++;
            }
        }
        return answer;
    }

}
