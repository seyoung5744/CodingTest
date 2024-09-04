import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static class Point {

        char c;
        Out out;

        static class Out {

            boolean left;
            boolean right;
            boolean top;
            boolean bottom;
        }

        public Point(char c) {
            this.c = c;
            this.out = new Out();
        }
    }

    public static Point[][] map;

    public static int findCircleLoop(int[] vector, int curY, int curX, int count) {
        while (true) {
            curY = (curY + map.length) % map.length;
            curX = (curX + map[0].length) % map[0].length;

            Point curPoint = map[curY][curX];

            if (vector[0] == 1 && vector[1] == 0) {
                if (curPoint.out.bottom) {
                    return count;
                }
                curPoint.out.bottom = true;
            } else if (vector[0] == -1 && vector[1] == 0) {
                if (curPoint.out.top) {
                    return count;
                }
                curPoint.out.top = true;
            } else if (vector[0] == 0 && vector[1] == 1) {
                if (curPoint.out.right) {
                    return count;
                }
                curPoint.out.right = true;
            } else if (vector[0] == 0 && vector[1] == -1) {
                if (curPoint.out.left) {
                    return count;
                }
                curPoint.out.left = true;
            }

            if (curPoint.c == 'R') {
                vector = turnRight(vector);
            } else if (curPoint.c == 'L'){
                vector = turnLeft(vector);
            }
            int ny = curY + vector[0];
            int nx = curX + vector[1];

            curY = ny;
            curX = nx;
            ++count;
        }

    }

    public static int[] solution(String[] grid) {

        List<Integer> answer = new ArrayList<>();

        map = new Point[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                map[i][j] = new Point(grid[i].charAt(j));
            }
        }

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                Point point = map[y][x];

                if (!point.out.bottom) {
                    answer.add(findCircleLoop(new int[]{1, 0}, y, x, 0));
                }
                if (!point.out.top) {
                    answer.add(findCircleLoop(new int[]{-1, 0}, y, x, 0));
                }
                if (!point.out.right) {
                    answer.add(findCircleLoop(new int[]{0, 1}, y, x, 0));
                }
                if (!point.out.left) {
                    answer.add(findCircleLoop(new int[]{0, -1}, y, x, 0));
                }
            }
        }

        return answer.stream()
            .filter(integer -> integer > 0)
            .sorted(Integer::compareTo)
            .mapToInt(Integer::intValue).toArray();
    }

    public static int[] turnRight(int[] vector) {
        return new int[]{vector[1], -vector[0]};
    }

    public static int[] turnLeft(int[] vector) {
        return new int[]{-vector[1], vector[0]};
    }
}
