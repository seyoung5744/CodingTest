import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            int idx = -1;
            char[] c = br.readLine().toCharArray();
            while (idx++ < N - 1) {
                board[i][idx] = c[idx];
            }
        }

        int answer = 0;
        answer = Math.max(answer, check(board));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    swap(board, i, j, i, j + 1);
                    answer = Math.max(answer, check(board));
                }
                swap(board, i, j, i, j + 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != board[i + 1][j]) {
                    swap(board, i, j, i + 1, j);
                    answer = Math.max(answer, check(board));
                }
                swap(board, i, j, i + 1, j);
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static int check(char[][] board) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                answer = Math.max(answer, count);
            }
        }

        for (int n = 0; n < N; n++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (board[i][n] == board[i + 1][n]) {
                    count++;
                }else {
                    count = 1;
                }
                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}
