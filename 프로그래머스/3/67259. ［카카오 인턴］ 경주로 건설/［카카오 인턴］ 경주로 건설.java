import java.util.Arrays;

public class Solution {

    public static int[] dx = {1, -1, 0, 0}; // 좌, 우, 하, 상
    public static int[] dy = {0, 0, 1, -1};
    public static int result = Integer.MAX_VALUE;
    public static int[][] check;

    public static int solution(int[][] board) {
        check = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(check[i], 200_000_000);
        }

        check[0][0] = 0;

        boolean[][] visited = new boolean[board.length][board.length];
        visited[0][0] = true;
        
        dfs(new int[]{0, 0}, 0, 0, visited, board);
        
        return result;
    }

    public static void dfs(int[] curPoint, int curCost, int curDirection, boolean[][] visited, int[][] board) {

        if (curPoint[0] == board.length - 1 && curPoint[1] == board.length - 1) {
            result = Math.min(curCost, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = curPoint[0] + dx[i];
            int ny = curPoint[1] + dy[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[ny][nx] == 1) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            int newCost = curCost + 100;

            if (curDirection != i && !(curPoint[0] == 0 && curPoint[1] == 0)) {
                newCost += 500;
            }

            if (check[ny][nx] + 500 < newCost) {
                continue;
            }

            check[ny][nx] = Math.min(check[ny][nx], newCost);
            visited[ny][nx] = true;
            dfs(new int[]{nx, ny}, newCost, i, visited, board);
            visited[ny][nx] = false;
        }
    }
}
