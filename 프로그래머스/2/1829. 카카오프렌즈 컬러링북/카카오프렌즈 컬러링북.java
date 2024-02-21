import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];

        for (int y = 0; y < m; ++y) {
            for (int x = 0; x < n; ++x) {
                if (picture[y][x] == 0 || visited[y][x]) {
                    continue;
                }

                answer[0]++;
                int areaCount = bfs(x, y, picture[y][x], m, n, visited, picture);

                if (answer[1] < areaCount) {
                    answer[1] = areaCount;
                }
            }
        }

        return answer;
    }

    public static int bfs(int x, int y, int target, int m, int n, boolean[][] visited, int[][] picture) {
        int areaCount = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (picture[ny][nx] != target || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new Point(nx, ny));
                areaCount++;
            }
        }

        return areaCount;
    }

}
