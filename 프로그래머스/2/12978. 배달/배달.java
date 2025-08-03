import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 500001);
        }
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            graph[a][b] = Math.min(graph[a][b], cost);
            graph[b][a] = Math.min(graph[b][a], cost);
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        

        for (int i = 2; i <= N; i++) {
            if (graph[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}