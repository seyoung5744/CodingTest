import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int[][] dirt = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = s[j - 1] - '0';
            }
        }

        visited = new boolean[N + 1][N + 1];
        int total = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    total += 1;
                    map[i][j] = -1;
                    dfs(i, j);
                    queue.add(count);
                }
            }
        }

        bw.write(total + "\n");
        while(!queue.isEmpty()){
            bw.write(queue.poll() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int i, int j) {
        count += 1;
        for (int[] dir : dirt) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x > 0 && y > 0 && x < N + 1 && y < N + 1 && map[x][y] == 1) {
                map[x][y] = -1;
                dfs(x, y);
            }
        }
    }
}
