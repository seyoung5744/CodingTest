import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getDistance(){
        return distance;
    }

    @Override
    public int compareTo(Node o){
        if(this.distance < o.distance){
            return -1;
        }
        return 1;
    }
}
public class Main {
    public static final int INF = (int)1e9;

    public static int n, m, start, end;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[1001];

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getIndex();
                int distance = graph.get(now).get(i).getDistance();

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

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new Node(b, cost));
        }

        Arrays.fill(d, INF);

        start = sc.nextInt();
        end = sc.nextInt();

        dijkstra(start);

        System.out.println(d[end]);
    }

}
