package 유형별_일고리즘_이론._09_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node3 implements Comparable<Node3>{
    private int index;
    private int distance;

    public Node3(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node3 o) {
        if(this.distance < o.distance){
            return -1;
        }

        return 1;
    }
}
public class 전보 {
    public static final int INF = (int)1e9;

    public static int n, m, start;

    public static ArrayList<ArrayList<Node3>> graph = new ArrayList<>();

    public static int[] d = new int[30001];

    private static void dijkstra(int start) {
        PriorityQueue<Node3> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.add(new Node3(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node3 node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[idx]){
                    d[idx] = cost;
                    pq.offer(new Node3(idx, cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node3(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int count = 0;
        int maxDistance = 0;

        for (int i = 1; i <= n; i++) {
            if(d[i] != INF){
                count+=1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);

    }



}
