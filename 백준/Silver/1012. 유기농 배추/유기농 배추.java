import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] map;
    static int[][] dirt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] MNK = br.readLine().split(" ");
            M = Integer.parseInt(MNK[0]); // 가로, 열
            N = Integer.parseInt(MNK[1]); // 세로, 행
            int K = Integer.parseInt(MNK[2]); // 배추 위치 개수
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]); 
                int y = Integer.parseInt(xy[1]); 
                map[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) { // 행
                for (int j = 0; j < M; j++) { // 열
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int X, int Y) {

        for (int[] dir : dirt) {
            int x = X + dir[0];
            int y = Y + dir[1];

            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    dfs(x, y);
                }
            }
        }
    }

}
