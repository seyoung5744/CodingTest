import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static final int INF = (int) 1e9;

    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        int[] start = getPosition(map, 'S');
        int[] lever = getPosition(map, 'L');
        int[] end = getPosition(map, 'E');


        int search1 = search(start, lever, map);
        int search2 = search(lever, end, map);

        if (search1 == INF || search2 == INF) {
            return -1;
        }
        return search1 + search2;
    }

    private int search(int[] start, int[] end, char[][] map) {

        int[][] visited = new int[map.length][map[0].length];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], INF);
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[1]][start[0]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == end[0] && curY == end[1]) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
                if (map[ny][nx] == 'X') continue;
                if (visited[ny][nx] <= visited[curY][curX] + 1) continue;

                visited[ny][nx] = visited[curY][curX] + 1;
                q.offer(new int[]{nx, ny});
            }

        }

        return visited[end[1]][end[0]];
    }

    private int[] getPosition(char[][] map, char target) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == target) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
