import java.util.*;

class Solution {
     public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {1, -1, 0, 0}; // 우, 좌, 상, 하
    public static int[] dy = {0, 0, -1, 1};

    public static int[] solution(String[] maps) {

        int[][] map = generateMap(maps);
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    int sum = dfs(new Point(j, i), map, visited);
                    result.add(sum);
                }
            }
        }

        return result.size() == 0 ? new int[]{-1} : result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int[][] generateMap(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            char[] c = maps[i].toCharArray();
            for (int j = 0; j < maps[0].length(); j++) {
                if(c[j] != 'X') {
                    map[i][j] = c[j] - '0';
                }
            }
        }
        return map;
    }

    public static int dfs(Point start, int[][] map, boolean[][] visited) {

        visited[start.y][start.x] = true;
        int sum = map[start.y][start.x];

        for (int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
            if(map[ny][nx] == 0 || visited[ny][nx]) continue;


            sum += dfs(new Point(nx, ny), map, visited);
        }

        return sum;
    }
}