import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[][] dirt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int M, N, K;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        map = new int[M][N]; // 5+1, 7+1
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            // 0 2 4 4
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        
        int total = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    total += 1;
                    dfs(i, j);
                    queue.add(count);
                }
            }
        }

        System.out.println(total);
        while(!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }


    public static void dfs(int i, int j) {

        for (int[] dir : dirt) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x > -1 && y > -1 && x < M && y < N) {
                if (map[x][y] == 0 && !visited[x][y]) {
                    count += 1;
                    visited[x][y] = true;
                    dfs(x, y);
                }
            }
        }
    }
}
