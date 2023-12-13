
public class Solution {

    public static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;

            dfs(computers, i);
            answer++;
        }

        return answer;
    }

    public static void dfs(int[][] computers, int cur) {
        visited[cur] = true;

        for (int i = 0; i < visited.length; i++) {
            if(i == cur || computers[cur][i] == 0 || visited[i]) continue;

            dfs(computers, i);
        }
    }
}
