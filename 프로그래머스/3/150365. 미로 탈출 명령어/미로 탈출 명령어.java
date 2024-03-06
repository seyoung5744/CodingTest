
public class Solution {

    public static final int[] dx = {0, -1, 1, 0}; // 하, 좌, 우, 상
    public static final int[] dy = {1, 0, 0, -1}; // 하, 좌, 우, 상
    public static char[] ch = {'d', 'l', 'r', 'u'};

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        y--;
        x--;
        c--;
        r--;
        
        if (getDistance(x, y, c, r) % 2 != k % 2 || getDistance(x, y, c, r) > k)
            return "impossible";

        while (k > 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dy[i];
                int ny = y + dx[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (getDistance(ny, nx, c, r) > k-1) {
                    continue;
                }

                x = nx;
                y = ny;
                k--;
                answer += ch[i];
                break;
            }
        }
        return answer;
    }

    public static int getDistance(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }

}
