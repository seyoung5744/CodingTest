import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {


    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) {
                    continue;
                }

                numberOfArea+=1;
                maxSizeOfOneArea = Math.max(bfs(m, n, picture, new int[]{i, j}), maxSizeOfOneArea);
            }
        }
        int[] result = new int[2];
        result[0] = numberOfArea;
        result[1] = maxSizeOfOneArea;
        return result;
    }

    public static int bfs(int m, int n, int[][] picture, int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int sizeOfArea = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[1];
                int ny = dy[i] + cur[0];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[ny][nx] || picture[ny][nx] != picture[start[0]][start[1]]) {
                    continue;
                }

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
                sizeOfArea += 1;
            }
        }
        return sizeOfArea;
    }

}
