import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] matrix;
    static boolean[] visited;
    static int count = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]); // 정점
        M = Integer.parseInt(NM[1]); // 간선

        if (M == 0) {
            count = N;
        } else {
            matrix = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                matrix[u][v] = 1;
                matrix[v][u] = 1;
            }

            visited = new boolean[N + 1];

            for (int i = 1; i < N + 1; i++) { // 행
                for (int j = 1; j < N + 1; j++) { // 열
                    if (matrix[i][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        dfs(j);
                        count++;
                    }
                }
            }
            for (int i = 1; i < N + 1; i++) {
                if(!visited[i]){
                    count++;
                }
            }
        }

        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int x) { //행
        for (int i = 1; i < N + 1; i++) {
            if (matrix[x][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
