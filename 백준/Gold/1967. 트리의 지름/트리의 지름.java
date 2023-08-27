import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {

        int edge;
        int cost;

        public Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }
    }

    public static ArrayList<Node>[] graph;
    public static boolean[] visited;
    public static int max = 0;
    public static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    private static void dfs(int start, int len) {
        if (len > max) {
            max = len;
            node = start;
        }
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Node node = graph[start].get(i);
            if (!visited[node.edge]) {
                visited[node.edge] = true;
                dfs(node.edge, len + node.cost);
            }
        }
    }

}
