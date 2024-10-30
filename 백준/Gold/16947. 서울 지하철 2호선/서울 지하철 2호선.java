import java.io.*;
import java.util.*;

class Result2 {

    public static List<Integer> cycleNodes = new ArrayList<>();
    public static List<List<Integer>> graph = new ArrayList<>();
    //public static int[] visited;

    public static int[] calculateDistances(int n_nodes, int s_edges, int[] s_from, int[] s_to) {

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < n_nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < s_from.length; i++) {
            int u = s_from[i];
            int v = s_to[i];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] visited = new int[n_nodes];
        Arrays.fill(visited, -1);
        Set<Integer> cycleNodes = new HashSet<>();

        findCycle(2, -1, graph, visited, cycleNodes);

        // 각 노드의 거리 계산
        int[] distance = new int[n_nodes];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();

//        System.out.println("사이클 : " + cycleNodes);
        for (int node : cycleNodes) {
            queue.offer(node);
            distance[node] = 0;  // 사이클에 있는 노드의 거리는 0
        }

        // BFS를 이용한 거리 계산
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) { // 아직 거리를 계산하지 않은 경우
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return distance;
    }

    public static boolean findCycle(int node, int parent, List<List<Integer>> graph, int[] visited, Set<Integer> cycleNodes) {
        if (visited[node] == 1) {
            return true;
        }

        visited[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;  // 부모 노드는 제외
            }
            if (visited[neighbor] == 1 || findCycle(neighbor, node, graph, visited, cycleNodes)) {

                if (cycleNodes.contains(node)) {
                    return false;
                }
                cycleNodes.add(node);
                cycleNodes.add(neighbor);
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] s_from = new int[n];
        int[] s_to = new int[n];
        int n_nodes = n;
        int s_edges = n;

        int idx = 0;
        while (n-- > 0) {
            String[] split = br.readLine().split(" ");
            s_from[idx] = Integer.parseInt(split[0]) - 1;
            s_to[idx] = Integer.parseInt(split[1]) - 1;
            idx++;
        }

        int[] result = Result2.calculateDistances(n_nodes, s_edges, s_from, s_to);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
