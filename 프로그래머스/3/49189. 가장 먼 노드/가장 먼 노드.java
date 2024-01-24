import java.util.*;

public class Solution {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] distance;
    public final static int INF = (int) 2e9;

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] point : edge) {
            int from = point[0];
            int to = point[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        distance[0] = 0;
        distance[1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {

            int cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);

                if (distance[next] <= distance[cur] + 1) {
                    continue;
                }

                distance[next] = distance[cur] + 1;
                q.add(next);
            }
        }
        int max = Arrays.stream(distance).max().getAsInt();
        return (int) Arrays.stream(distance)
            .filter(i -> i == max)
            .count();
    }


}
