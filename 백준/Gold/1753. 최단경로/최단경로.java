import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {

    public static final int INF = (int) 1e9;
    public static int v, e, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[20_001];

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getCost();

            if(d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getIndex();
                int distance = graph.get(now).get(i).getCost();

                int cost = d[now] + distance;
                if(cost < d[idx]){
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new Node(b, cost));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            if(d[i] == INF){
                System.out.println("INF");
            }else {
                System.out.println(d[i]);
            }
        }
    }


}
