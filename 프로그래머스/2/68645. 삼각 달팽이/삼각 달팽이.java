class Solution {
    public static final int[] dx = {0, 1, -1};
    public static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        int loop = 0;
        for (int i = 1; i <= n; i++) {
            loop += i;
        }

        int[] answer = new int[loop];
        int[][] map = new int[n][n];

        int num = 1;
        int x = 0;
        int y = 0;
        int direction = 0;
        while (loop-- > 0) {

            map[y][x] = num++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[ny][nx] != 0) {
                direction = (direction + 1) % 3;

                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0) {
                    answer[idx++] = map[i][j];
                }
            }
        }
        return answer;
    }
}