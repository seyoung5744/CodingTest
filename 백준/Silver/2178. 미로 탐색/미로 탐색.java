import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int[][] dirt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            char[] chrNums = br.readLine().toCharArray();
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = chrNums[j - 1] - '0';
            }
        }
        bfs(1, 1, 1);

        bw.write(map[N][M] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x, int y, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirt) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextY > 0 && nextX > 0 && nextX < N + 1 && nextY < M + 1) {
                    if (map[nextX][nextY] == 1) {
                        queue.add(new int[]{nextX, nextY});
                        map[nextX][nextY] = map[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}
