import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] matrix;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMV = br.readLine().split(" ");
        int N = Integer.parseInt(NMV[0]); // 정점 개수
        int M = Integer.parseInt(NMV[1]); // 간선 개수
        int V = Integer.parseInt(NMV[2]); // 시작 정점

        matrix = new int[N + 1][N + 1];
        String[] ab;
        for (int i = 0; i < M; i++) {
            ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        
        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        
        if(V == matrix.length){
            return;
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        System.out.print(V + " ");

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[num][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
