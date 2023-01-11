import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int[][] dirt = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int count = 1;

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
        List<Integer> answer = new ArrayList<>();

        int groupCnt = 1;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = groupCnt;
                    visited[i][j] = true;
                    dfs(i, j, groupCnt);
                    answer.add(count);
                    groupCnt += 1;
                    count = 1;
                }
            }
        }
        Collections.sort(answer);

        bw.write(groupCnt - 1 + "\n");

        for (int cnt : answer) {
            bw.write(cnt + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int i, int j, int groupCnt) {

        for (int[] dir : dirt) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x > 0 && y > 0 && x < N + 1 && y < N + 1 && map[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                map[x][y] = groupCnt;
                count += 1;
                dfs(x, y, groupCnt);
            }
        }
    }
}
