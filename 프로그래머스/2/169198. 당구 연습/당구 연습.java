import java.util.Arrays;

public class Solution {

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        int[][] pointXY = new int[][]{ // 상하좌우
            {startX, 2 * n - startY},
            {startX, -startY},
            {-startX, startY},
            {2 * m - startX, startY}
        };

        for (int i = 0; i < balls.length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            int distance = Integer.MAX_VALUE;
            
            if (!(x == startX && y > startY))
            {
                distance = Math.min(getDistance(pointXY[0][0], pointXY[0][1], x, y), distance); // 상
            }
            
            if (!(x == startX && y < startY))
            {
                distance = Math.min(getDistance(pointXY[1][0], pointXY[1][1], x, y), distance); // 하
            }
            
            if (!(y == startY && x < startX))
            {
                distance = Math.min(getDistance(pointXY[2][0], pointXY[2][1], x, y), distance); // 좌
            }
            
            if (!(y == startY && x > startX))
            {
                distance = Math.min(getDistance(pointXY[3][0], pointXY[3][1], x, y), distance); // 우
            }

            answer[i] = distance;
        }

        return answer;
    }

    public static int getDistance(int a, int b, int x, int y) {
        return (int) Math.pow((a - x), 2) + (int) Math.pow((b - y), 2);
    }
}
