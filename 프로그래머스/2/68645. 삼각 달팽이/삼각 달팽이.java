public class Solution {

    public static int[] dx = {0, 1, -1}; // 아래, 오, 왼위
    public static int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] nums = new int[n][n];
        int number = 1;

        int direction = 0;

        int curX = 0;
        int curY = 0;

        int end = 0;
        for (int i = 0; i <= n; i++) {
            end += i;
        }

        while (number <= end) {

            nums[curY][curX] = number++;

            int nx = curX + dx[direction];
            int ny = curY + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || nums[ny][nx] != 0) {
                direction = (direction + 1) % 3;

                nx = curX + dx[direction];
                ny = curY + dy[direction];
            }

            curX = nx;
            curY = ny;

        }

        int[] answer = new int[end];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] != 0) {
                    answer[idx++] = nums[i][j];
                }
            }
        }
        return answer;
    }
}
