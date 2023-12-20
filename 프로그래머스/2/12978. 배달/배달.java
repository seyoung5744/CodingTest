import java.util.Arrays;

public class Solution {

    public static int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    public static int[][] graph = new int[51][51]; // 1~50

    public static int solution(int N, int[][] roads, int K) {
        int answer = 0;

        for(int[] g : graph) {
            Arrays.fill(g, INF);
        }

        for (int i = 0; i <= N; i++) {
            graph[i][i] = 0;
        }

        for(int[] road : roads) {
            int node1 = road[0];
            int node2 = road[1];
            int distance = road[2];

            graph[node1][node2] = Math.min(graph[node1][node2], distance);
            graph[node2][node1] = Math.min(graph[node2][node1], distance);
        }

        for (int k = 1; k <= N ; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    graph[j][i] = graph[i][j];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(graph[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }



}
