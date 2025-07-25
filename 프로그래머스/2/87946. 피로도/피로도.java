class Solution {
    public static int answer = -1;

    public int solution(int k, int[][] dungeons) {
        dfs(0, k, new boolean[dungeons.length], dungeons);
        return answer;
    }

    public void dfs(int count, int k, boolean[] visited, int[][] dungeons) {
        if (count > answer) {
            answer = count;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0]) continue;

            visited[i] = true;
            dfs(count + 1, k - dungeons[i][1], visited, dungeons);
            visited[i] = false;
        }
    }
}