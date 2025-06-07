class Solution {
    public static final int[] dx = {0, 1, -1};
    public static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int direction = 0;
        int x = 0, y = 0;
        int num = 1;

        int loop = (n * (2 + (n - 1))) / 2;

        while (loop-- > 0) {
            triangle[y][x] = num++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[ny][nx] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[(n * (2 + (n - 1))) / 2];
        int idx = 0;
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }

        return answer;
    }
}