import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static String[] solution(int[][] line) {

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        List<long[]> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (isParallel(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2])) {
                    continue;
                }
                double x = getX(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                double y = getY(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (isInteger(x) && isInteger(y)) {
                    minX = Math.min((long) x, minX);
                    maxX = Math.max((long) x, maxX);
                    minY = Math.min((long) y, minY);
                    maxY = Math.max((long) y, maxY);
                    points.add(new long[]{(long) x, (long) y});
                }
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(map[i], '.');
        }

        for (long[] point : points) {
            map[(int) (maxY - point[1])][(int) (point[0] - minX)] = '*';
        }
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }
        return answer;
    }

    public static boolean isInteger(double num) {
        return (long) num == num;
    }

    public static boolean isParallel(double A, double B, double E, double C, double D, double F) {
        return (A * D - B * C) == 0;
    }

    public static double getX(double A, double B, double E, double C, double D, double F) {
        return (B * F - E * D) / (A * D - B * C);
    }

    public static double getY(double A, double B, double E, double C, double D, double F) {
        return (E * C - A * F) / (A * D - B * C);
    }
}
