
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int[] dx = {1, -1, 0, 0}; // 우, 좌, 상, 하
    public static int[] dy = {0, 0, -1, 1};

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static class Robot {

        Point[] point = new Point[2];
        int moveCount;

        public Robot(int x1, int y1, int x2, int y2, int moveCount) {
            point[0] = new Point(Math.min(x1, x2), Math.min(y1, y2));
            point[1] = new Point(Math.max(x1, x2), Math.max(y1, y2));
            this.moveCount = moveCount;
        }
    }

    public static int solution(int[][] board) {
        int answer = 0;

        boolean[][][] visited = new boolean[2][board.length][board[0].length];

        Queue<Robot> q = new LinkedList<>();
        q.offer(new Robot(0, 0, 1, 0, 0));
        visited[1][0][0] = true;


        while (!q.isEmpty()) {
            Robot cur = q.poll();

            if ((cur.point[0].x == board[0].length - 1 && cur.point[0].y == board.length - 1) ||
                (cur.point[1].x == board[0].length - 1 && cur.point[1].y == board.length - 1))
            {
                return cur.moveCount;
            }

            for(int i = 0; i < 4; ++i)
            {
                int nx1 = cur.point[0].x + dx[i];
                int ny1 = cur.point[0].y + dy[i];
                int nx2 = cur.point[1].x + dx[i];
                int ny2 = cur.point[1].y + dy[i];

                if (nx1 < 0 || nx2 < 0 || nx1 >= board[0].length || nx2 >= board[0].length ||
                    ny1 < 0 || ny2 < 0 || ny1 >= board.length || ny2 >= board.length)
                    continue;

                if (board[ny1][nx1] == 1 || board[ny2][nx2] == 1)
                    continue;


                Robot next = new Robot(nx1, ny1, nx2, ny2, cur.moveCount + 1);

                if (visited[next.point[1].x - next.point[0].x][next.point[0].y][next.point[0].x])
                    continue;

                visited[next.point[1].x - next.point[0].x][next.point[0].y][next.point[0].x] = true;
                q.offer(next);
            }


            for(int i = 0; i < 2; ++i)
            {
                Point axis = new Point(cur.point[i].x, cur.point[i].y);
                Point mPoint = new Point(cur.point[(i + 1) % 2].x, cur.point[(i + 1) % 2].y);

                for(int j = 0 ; j < 2; ++j)
                {
                    Point newPoint = Rotate(axis, mPoint, j);

                    if (newPoint.x < 0 || newPoint.x >= board[0].length  || newPoint.y < 0 || newPoint.y >= board.length)
                        continue;

                    if (board[newPoint.y][newPoint.x] == 1 || board[newPoint.y][mPoint.x] == 1 || board[mPoint.y][newPoint.x] == 1)
                        continue;

                    Robot next = new Robot(axis.x, axis.y, newPoint.x, newPoint.y, cur.moveCount + 1);

                    if (visited[next.point[1].x - next.point[0].x][next.point[0].y][next.point[0].x])
                        continue;

                    visited[next.point[1].x - next.point[0].x][next.point[0].y][next.point[0].x] = true;
                    q.offer(next);
                }
            }
        }

        return answer;
    }

    public static Point Rotate(Point axis, Point mPoint, int dir)
    {
        int newX = mPoint.x - axis.x;
        int newY = mPoint.y - axis.y;

        if (dir == 0)
        {
            return new Point(-newY + axis.x, newX + axis.y);
        }
        else
        {
            return new Point(newY + axis.x, -newX + axis.y);
        }
    }

}
