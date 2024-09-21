
import java.util.*;

public class Solution {

    public static int[] dx = {0, -1, 1, 0}; // d l r u
    public static int[] dy = {1, 0, 0, -1};
    public static Map<Integer, Character> map = Map.of(
        0, 'd',
        1, 'l',
        2, 'r',
        3, 'u'
    );

    public static int getDistance(int startI, int startJ, int endI, int endJ) {
        return Math.abs(startI - endI) + Math.abs(startJ - endJ);
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        int curJ = y - 1;
        int curI = x - 1;
        int endJ = c - 1;
        int endI = r - 1;

        if (getDistance(curI, curJ, endI, endJ) % 2 != k % 2 || getDistance(curI, curJ, endI, endJ) > k)
            return "impossible";

        int moveCount = 0;

        while (moveCount < k) {

            for (int i = 0; i < 4; i++) {
                int nextI = curI + dy[i];
                int nextJ = curJ + dx[i];

                if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m) {
                    continue;
                }

                if (moveCount + 1 + getDistance(nextI, nextJ, endI, endJ) > k) {
                    continue;
                }

                moveCount += 1;
                curI = nextI;
                curJ = nextJ;
                answer += map.get(i);
                break;
            }

        }

        return answer;
    }
}