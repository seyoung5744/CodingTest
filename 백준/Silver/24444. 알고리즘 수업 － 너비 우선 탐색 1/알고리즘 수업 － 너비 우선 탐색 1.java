import java.util.*;

public class Main {
    public static int N, M, R, cnt = 1;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited = new boolean[100_001];
    public static int[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        results = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        visited[R] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            results[cur] = cnt;
            cnt++;
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(results[i]).append("\n");
        }
        System.out.println(sb);

    }

}
