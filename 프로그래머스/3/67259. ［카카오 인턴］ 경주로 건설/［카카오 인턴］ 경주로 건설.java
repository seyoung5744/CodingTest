import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    static class Road {

        int x;
        int y;
        int cost;
        Road pre;

        public Road(int x, int y, int cost, Road pre) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.pre = pre;
        }
    }

    public static int[] dx = {1, -1, 0, 0}; // 좌, 우, 상, 하
    public static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] board) {

        int size = board.length - 1;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (board[i][j] == 1) continue;
                board[i][j] = Integer.MAX_VALUE;
            }
        }
        board[0][0] = 0;
        return bfs(board);
    }

    public static int bfs(int[][] visited) {
        int size = visited.length - 1;

        Queue<Road> q = new ArrayDeque<>();
        q.add(new Road(0, 0, 0, null));

        int result = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Road cur = q.poll();

            if (cur.x == size && cur.y == size) {
                result = Math.min(result, cur.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (nx < 0 || nx > size || ny < 0 || ny > size
                    || visited[ny][nx] == 1) {
                    continue;
                }

                int cost = 100;
                if (cur.pre != null && cur.pre.x != nx && cur.pre.y != ny) {
                    cost += 500;
                }

                cost += cur.cost;

                if (visited[ny][nx] > cost) {
                    visited[ny][nx] = cost;
                    q.add(new Road(nx, ny, cost, cur));
                } else if (visited[ny][nx] + 500 >= cost) {
                    q.add(new Road(nx, ny, cost, cur));
                }
            }
        }
        return result;
    }

}
