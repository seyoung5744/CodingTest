class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            int u = result[0];
            int v = result[1];
            graph[u][v] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            int wins = countForward(i, graph, new boolean[n + 1]) - 1;
            int loses = countBackward(i, graph, new boolean[n + 1]) - 1;

            if(wins + loses + 1 == n){
                answer += 1;
            }
        }

        return answer;
    }

    private static int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;
        isVisited[u] = true;

        for (int v = 1; v < graph[u].length; v++) {
            if (graph[u][v] && !isVisited[v]) {
                count += countForward(v, graph, isVisited);
            }
        }

        return count;
    }

    private static int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;
        isVisited[u] = true;

        for (int v = 1; v < graph[u].length; v++) {
            if(graph[v][u] && !isVisited[v]){
                count += countBackward(v, graph, isVisited);
            }
        }

        return count;
    }
}
