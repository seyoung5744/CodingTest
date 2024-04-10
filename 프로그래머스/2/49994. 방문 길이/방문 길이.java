import java.util.Map;

public class Solution {

    public static Map<Character, int[]> d = Map.ofEntries(
        Map.entry('L', new int[]{-1, 0}),
        Map.entry('R', new int[]{1, 0}),
        Map.entry('D', new int[]{0, 1}),
        Map.entry('U', new int[]{0, -1})
    );

    public static Cell[][] map = new Cell[11][11];
    public static int result = 0;

    static class Cell {

        int x, y;
        boolean up, down, left, right;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String dirs) {
        for (int y = 0; y <= 10; y++) {
            for (int x = 0; x <= 10; x++) {
                map[y][x] = new Cell(x, y);
            }
        }

        test(5, 5, dirs);
        return result;
    }

    public static void test(int x, int y, String dirs) {

        for (char dir : dirs.toCharArray()) {
            int[] dxy = d.get(dir);
            int nx = x + dxy[0];
            int ny = y + dxy[1];

            if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) {
                continue;
            }

            if (dir == 'L') {
                if(map[y][x].right && map[ny][nx].left) {
                    x = nx;
                    y = ny;
                    continue;
                }
                map[y][x].right = true;
                map[ny][nx].left = true;
            } else if (dir == 'R') {
                if(map[y][x].left && map[ny][nx].right) {
                    x = nx;
                    y = ny;
                    continue;
                }
                map[y][x].left = true;
                map[ny][nx].right = true;
            } else if (dir == 'U') {
                if(map[y][x].up && map[ny][nx].down) {
                    x = nx;
                    y = ny;
                    continue;
                }
                map[y][x].up = true;
                map[ny][nx].down = true;
            } else {
                if(map[y][x].down && map[ny][nx].up) {
                    x = nx;
                    y = ny;
                    continue;
                }
                map[y][x].down = true;
                map[ny][nx].up = true;
            }

            x = nx;
            y = ny;
            result++;
        }
    }

}
