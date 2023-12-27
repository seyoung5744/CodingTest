import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static char[][] map;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int solution(String[] maps) {
        int answer = 0;

        map = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }


        Point start = getPosition('S');
        Point end = getPosition('E');
        Point lever = getPosition('L');

        int a = bfs(start, lever);
        int b = bfs(lever, end);
        
        if(a == -1 || b == -1) return -1;
        
        
        return a + b;
    }

    public static int bfs(Point start, Point end) {
        int[][] visited = new int[map.length][map[0].length];

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x] = 1;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if(cur.x == end.x && cur.y == end.y) {
                return visited[end.y][end.x] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;

                if(map[ny][nx] == 'X' || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        return -1;
    }

    public static Point getPosition(char target) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if(map[y][x] == target) {
                    return new Point(x, y);
                }
            }
        }
        return null;
    }


}
