public class Solution {
    public static final int[] dx = {0, 1, -1}; // 하, 우, 대각선 위
    public static final int[] dy = {1, 0, -1};

    public static int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        int direction = 0;

        while(true) {
            triangle[y][x] = num++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];

                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[num - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }

}
