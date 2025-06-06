import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        List<long[]> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                double x = getX(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                double y = getY(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (x % 1 != 0 || y % 1 != 0) continue;

                minX = Math.min(minX, (long) x);
                maxX = Math.max(maxX, (long) x);
                minY = Math.min(minY, (long) y);
                maxY = Math.max(maxY, (long) y);
                points.add(new long[]{(long) x, (long) y});
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        char[][] map = new char[height][width];
        for (char[] arr : map) {
            Arrays.fill(arr, '.');
        }

        for (long[] point : points) {
            int x = (int) (point[0] - minX);
            int y = (int) (maxY - point[1]);
            map[y][x] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }

    public double getX(long a, long b, long e, long c, long d, long f) {
        return (double)((b * f) - (e * d)) / ((a * d) - (b * c));
    }

    public double getY(long a, long b, long e, long c, long d, long f) {
        return (double)((e * c) - (a * f)) / ((a * d) - (b * c));
    }
}