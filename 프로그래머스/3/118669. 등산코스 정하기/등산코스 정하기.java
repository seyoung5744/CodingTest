import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class Node implements Comparable<Node> {

        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static int[] type = new int[50001];
    static int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[100001];


    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        for (int i = 1; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int cost = path[2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        Arrays.fill(d, INF);

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < gates.length; i++) {
            type[gates[i]] = 1; // 입구
            pq.offer(new Node(gates[i], 0));
            d[gates[i]] = 0;
        }
        for (int i = 0; i < summits.length; i++) {
            type[summits[i]] = 2; // 산봉우리
        }

        dijkstra(pq);

        return answer;
    }

    public static void dijkstra(Queue<Node> pq) {

        // 1.   while문을 돈다. heap의 데이터가 모두 없어질 때 까지.
        while (!pq.isEmpty()) {
            //   2. heap의 데이터를 팝해서 하나 가져온다.
            Node node = pq.poll();
            int now = node.idx;
            int dist = node.distance;

            // 3. 가져온 데이터의 정점이 산봉우리인지 판단한다. 산봉우리라면, continue한다.
            if (type[now] == 2) {
                // 답 갱신 ??
                if (dist < answer[1]) {
                    answer[0] = now;
                    answer[1] = dist;
                } else if (dist == answer[1]) {
                    if (now < answer[0]) {
                        answer[0] = now;
                        answer[1] = dist;
                    }
                }
                continue;
            }

            // 4. 가져온 데이터의 강도가 현재 정점의 강도보다 높다면, 버려도 되는 데이터이므로, continue한다.
            if (d[now] < dist) {
                continue;
            }

            // 5. 해당 정점에서 갈 수 있는 자식 정점들을 for문을 순회한다.
            for (int i = 0; i < graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).idx;
                int distance = graph.get(now).get(i).distance;

                // 6. 자식 정점이 출입구에 정점인지 확인한다. 출입구 정점에는 가면 안되기에, 바로 continue때린다.
                if (type[idx] == 1) {
                    continue;
                }

                // 7. 자식 정점의 강도를 업데이트 해야한다. 현재 강도에, 자식정점까지 가는 비용에서 최댓값을 구한다.
                int cost = Math.max(d[now], distance);

                // 8. 구해진 새로운 강도가 DP[자식 정점]의 값 이상이면, 굳이 있어봤자 시간만 늘어나므로, continue 때린다.
                if (d[idx] <= cost) {
                    continue;
                }

                // 9. 모든 조건을 만족한, 데이터만이 (새로운 강도, 자식정점) 의 데이터를 heap에 push할 수 있게 된다.
                pq.offer(new Node(idx, cost));

                // 10. DP변수의 값을 업데이터 해준다.
                d[idx] = cost;
            }
        }
    }

}
