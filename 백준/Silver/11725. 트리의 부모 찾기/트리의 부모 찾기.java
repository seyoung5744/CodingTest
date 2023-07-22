import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[] parents = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        dfs(parents, visited, 1, 0);
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int[] parents, boolean[] visited, int start, int parent) {
        parents[start] = parent;
        visited[start] = true;

        for (int i = 0; i < list.get(start).size(); i++) {
            int cur = list.get(start).get(i);
            if (!visited[cur]) {
                dfs(parents, visited, cur, start);
            }
        }
    }

}
