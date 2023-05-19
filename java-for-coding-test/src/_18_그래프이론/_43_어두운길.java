package _18_그래프이론;

import java.util.*;

/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
 */
class Edge implements Comparable<Edge>{
    int nodeA;
    int nodeB;
    int distance;

    public Edge(int nodeA, int nodeB, int distance){
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Edge other){
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}
public class _43_어두운길 {

    public static int v, e;
    public static int[] parent = new int[2000001];

    public static ArrayList<Edge> edges = new ArrayList<Edge>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        int total = 0;
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();
            int cost = sc.nextInt();
            total += cost;
            edges.add(new Edge(a, b, cost));
        }

        Collections.sort(edges);

        int result = 0;

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            int nodeA = edge.getNodeA();
            int nodeB = edge.getNodeB();
            int cost = edge.getDistance();

            if(find(nodeA) != find(nodeB)){
                union(nodeA, nodeB);
                result += cost;
            }
        }

        System.out.println(total - result);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

}
