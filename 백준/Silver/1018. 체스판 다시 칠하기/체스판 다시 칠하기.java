import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); // 행
        int M = Integer.parseInt(NM[1]); // 열

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, checkBoard(i, j, i + 8, j + 8, board));
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static char[] pattern1 = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
    public static char[] pattern2 = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};

    public static int checkBoard(int x, int y, int row, int col, char[][] board) {
        char[] pattern = null;
        int answer = Integer.MAX_VALUE;
        for (int n = 0; n < 2; n++) {
            int cnt = 0;
            boolean flag = (n % 2 == 0);
            for (int i = x; i < row; i++) {
                pattern = flag ? pattern1 : pattern2;
                for (int j = y; j < col; j++) {
                    if (board[i][j] != pattern[j - y]) {
                        cnt++;
                    }
                }
                flag = !flag;
            }
            answer = Math.min(answer, cnt);
        }

        return answer;
    }
}
