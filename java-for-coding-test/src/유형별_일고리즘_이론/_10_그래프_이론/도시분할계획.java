package 유형별_일고리즘_이론._10_그래프_이론;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 6
6 7 4
 */
class Edge2 implements Comparable<Edge2>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge2(int distance, int nodeA, int nodeB){
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance(){
        return distance;
    }

    public int getNodeA(){
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge2 other){
        if(this.distance < other.distance){
            return -1;
        }

        return 1;
    }
}
public class 도시분할계획 {
    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    public static int n, m;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화
    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    public static ArrayList<Edge2> edges = new ArrayList<>();
    public static int result = 0;

    public static int findParent(int x){
        if(x != parent[x]){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge2(cost, a, b));
        }

        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            Edge2 edge = edges.get(i);
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }

}
