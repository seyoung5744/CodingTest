import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int cnt, remove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        remove = Integer.parseInt(br.readLine());

        int root = -1;

        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == -1){
                root = i;
            }

            if(parents[i] != -1){
                if (parents[i] != remove && i != remove) {
                    graph.get(parents[i]).add(i);
                }
            }
        }

        visited = new boolean[n + 1];
        dfs(root);

        System.out.println(cnt);
    }

    private static void dfs(int start) {
        if(start == remove) return;
        if (graph.get(start).size() == 0) {
            cnt += 1;
        }

        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

}
