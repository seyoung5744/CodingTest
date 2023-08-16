import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Board {

        int x;
        int y;
        char data;
        int color;

        public Board(int x, int y, char data, int color) {
            this.x = x;
            this.y = y;
            this.data = data;
            this.color = color;
        }
    }

    private static int n;
    private static Board[][] board;
    private static int result;

    private static final int[] dy = {-1, -1, 0, 0, 1, 1};
    private static final int[] dx = {0, 1, -1, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new Board[n][n];

        for (int y = 0; y < n; y++) {
            char[] cArr = br.readLine().toCharArray();
            for (int x = 0; x < n; x++) {
                board[y][x] = new Board(x, y, cArr[x], -1);
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x].data == 'X' && board[y][x].color == -1) {
                    dfs(x, y, 0);
                }
            }
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y, int color) {
        board[y][x].color = color;
        result = Math.max(result, 1);

        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                continue;
            }

            if (board[ny][nx].data == 'X') {
                if (board[ny][nx].color == -1) {
                    dfs(nx, ny, 1 - color);
                }
                result = Math.max(result, 2);

                if (board[ny][nx].color == color) {
                    result = Math.max(result, 3);
                }
            }

        }
    }

}
