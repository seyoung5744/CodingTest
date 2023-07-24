import java.io.*;
import java.util.*;

class Node {

    int edge;
    int cost;

    public Node(int edge, int cost) {
        this.edge = edge;
        this.cost = cost;
    }
}

public class Main {

    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int max = 0;
    public static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int edge = Integer.parseInt(st.nextToken());
                if (edge == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                list[start].add(new Node(edge, cost));
            }
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
        for (int i = 0; i < list[start].size(); i++) {
            Node node = list[start].get(i);
            if (!visited[node.edge]) {
                visited[node.edge] = true;
                dfs(node.edge, len + node.cost);
            }
        }
    }

}
