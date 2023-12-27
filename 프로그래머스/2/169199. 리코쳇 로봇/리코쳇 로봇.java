
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public int solution(String[] board) {

        Point start = null;
        Point end = null;
        visited = new int[board.length][board[0].length()];

        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[0].length(); x++) {
                if(board[y].charAt(x) == 'R') {
                    start = new Point(x, y);
                }else if(board[y].charAt(x) == 'G'){
                    end = new Point(x, y);
                }
            }
        }

        bfs(board, start, end);
        
        return visited[end.y][end.x] - 1;
    }

    public static void bfs(String[] board, Point start, Point end) {

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x] = 1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if(cur.x == end.x && cur.y == end.y) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;

                while(true) {

                    int blockedX = nx + dx[i];
                    int blockedY = ny + dy[i];

                    if(blockedX < 0 || blockedX >= board[0].length() || blockedY < 0 || blockedY >= board.length) break;

                    if(board[blockedY].charAt(blockedX) == 'D')  break;

                    nx += dx[i];
                    ny += dy[i];
                }
                
                if(visited[ny][nx] != 0) continue;
                
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                q.offer(new Point(nx, ny));
            }
        }
    }

}
