import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new ArrayList<>();

        int[][] startPoints = new int[4][];
        startPoints[0] = new int[]{startX, (2 * n) - startY}; // 위
        startPoints[1] = new int[]{startX, -startY}; // 아래
        startPoints[2] = new int[]{-startX, startY}; // 좌
        startPoints[3] = new int[]{(2 * m) - startX, startY}; // 우

        for (int[] ball : balls) {

            int minDistance = Integer.MAX_VALUE;

            // 위
            if (startX != ball[0] || startY > ball[1]) // 위
            {
                minDistance = Math.min(getDistance(startPoints[0][0], startPoints[0][1], ball[0], ball[1]), minDistance);
            }

            if (startX != ball[0] || startY < ball[1]) // 아래
            {
                minDistance = Math.min(getDistance(startPoints[1][0], startPoints[1][1], ball[0], ball[1]), minDistance);
            }

            if (startY != ball[1] || startX < ball[0]) // 왼
            {
                minDistance = Math.min(getDistance(startPoints[2][0], startPoints[2][1], ball[0], ball[1]), minDistance);
            }

            if (startY != ball[1] || startX > ball[0]) // 오
            {
                minDistance = Math.min(getDistance(startPoints[3][0], startPoints[3][1], ball[0], ball[1]), minDistance);
            }
            answer.add(minDistance);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2));
    }

}
