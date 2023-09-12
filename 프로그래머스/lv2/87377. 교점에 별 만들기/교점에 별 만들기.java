import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static class Point {

        public final long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }
        return new Point((long) x, (long) y);
    }

    private static Point getMaxPoint(List<Point> points) {
        long x = points.get(0).x;
        long y = points.get(0).y;

        for (int i = 1; i < points.size(); i++) {
            x = Math.max(x, points.get(i).x);
            y = Math.max(y, points.get(i).y);
        }

        return new Point(x, y);
    }

    private static Point getMinPoint(List<Point> points) {
        long x = points.get(0).x;
        long y = points.get(0).y;

        for (int i = 1; i < points.size(); i++) {
            x = Math.min(x, points.get(i).x);
            y = Math.min(y, points.get(i).y);
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point max = getMaxPoint(points);
        Point min = getMinPoint(points);

        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);

        char[][] map = new char[height][width];
        for (char[] arr : map) {
            Arrays.fill(arr, '.');
        }

        for (Point point : points) {
            int x = (int) (point.x - min.x);
            int y = (int) (max.y - point.y);
            map[y][x] = '*';
        }

        String[] answer = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}
