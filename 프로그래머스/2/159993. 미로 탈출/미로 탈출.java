import java.util.*;

public class Solution {

    public static char[][] map;

    public static int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];

        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c;
                if (c == 'S') {
                    start = new int[]{j, i};
                } else if (c == 'E') {
                    end = new int[]{j, i};
                } else if (c == 'L') {
                    lever = new int[]{j, i};
                }
            }
        }

        int result1 = bfs(start, lever);
        int result2 = bfs(lever, end);

        if(result1 == INF || result2 == INF) {
            return -1;
        }
        return result1 + result2;
    }

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static final int INF = (int) 1e9;
    
    public static int bfs(int[] start, int[] end) {
        int[][] visited = new int[map.length][map[0].length];
        
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], INF);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[1]][start[0]] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == end[0] && cur[1] == end[1]) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;

                if(map[ny][nx] == 'X') continue;

                if(visited[ny][nx] <= visited[cur[1]][cur[0]] + 1) continue;

                visited[ny][nx] = visited[cur[1]][cur[0]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return visited[end[1]][end[0]];
    }

}
