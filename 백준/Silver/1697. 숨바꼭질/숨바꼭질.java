import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int maxLen = 100_001;

        int[] visited = new int[maxLen];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (M == cur) {
                break;
            }

            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                visited[cur - 1] = visited[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur + 1 < maxLen && visited[cur + 1] == 0) {
                visited[cur + 1] = visited[cur] + 1;
                queue.add(cur + 1);
            }
            if (cur * 2 < maxLen && visited[cur * 2] == 0) {
                visited[cur * 2] = visited[cur] + 1;
                queue.add(cur * 2);
            }
        }

        bw.write(visited[M] - 1 + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
