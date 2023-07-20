class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        for (int i = 0; i < n; i++) {
            int wins = countForward(i, graph, new boolean[n]) - 1;
            int loses = countBackward(i, graph, new boolean[n]) - 1;

            if(wins + loses + 1 == n){
                answer++;
            }
        }
        return answer;
    }

    private static int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[u][v] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }

        return count;
    }
    private static int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[v][u] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }

        return count;
    }
}