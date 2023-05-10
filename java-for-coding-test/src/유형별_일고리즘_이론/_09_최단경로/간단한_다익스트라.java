//package 유형별_일고리즘_이론._09_최단경로;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
///*
//6 11
//1
//1 2 2
//1 3 5
//1 4 1
//2 3 3
//2 4 2
//3 2 3
//3 6 5
//4 3 3
//4 5 1
//5 3 1
//5 6 2
// */
//class Node {
//
//    private int index;
//    private int distance;
//
//    public Node(int index, int distance) {
//        this.index = index;
//        this.distance = distance;
//    }
//
//    public int getIndex() {
//        return index;
//    }
//
//    public int getDistance() {
//        return distance;
//    }
//}
//
//public class 간단한_다익스트라 {
//
//    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
//    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
//    // 노드의 개수는 최대 100,000개라고 가정
//    public static int n, m, start;
//    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
//    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
//    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
//    public static boolean[] visited = new boolean[100001];
//    // 최단 거리 테이블 만들기
//    public static int[] d = new int[100001];
//
//    private static void dijkstra(int start) {
//        // 시작 노드에 대해서 초기화
//        d[start] = 0;
//        visited[start] = true;
//
//        for (int i = 0; i < graph.get(start).size(); i++) {
//            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
//        }
//
//        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
//        for (int i = 0; i < n - 1; i++) {
//            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
//            int now = getSmallestNode();
//            visited[now] = true;
//            // 현재 노드와 연결된 다른 노드를 확인
//            for (int j = 0; j < graph.get(now).size(); j++) {
//                int cost = d[now] + graph.get(now).get(j).getDistance();
//                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 갱신
//                if(cost < d[graph.get(now).get(j).getIndex()]){
//                    d[graph.get(now).get(j).getIndex()] = cost;
//                }
//            }
//        }
//    }
//
//    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
//    private static int getSmallestNode() {
//        int minIndex = 0;
//        int minValue = INF;
//
//        for (int i = 1; i <= n; i++) {
//            if(minValue > d[i] && !visited[i]){
//                minIndex = i;
//                minValue = d[i];
//            }
//        }
//        return minIndex;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        n = sc.nextInt();
//        m = sc.nextInt();
//        start = sc.nextInt();
//
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < m; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c = sc.nextInt();
//            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
//            graph.get(a).add(new Node(b, c));
//        }
//
//        // 최단 거리 테이블을 모두 무한으로 초기화
//        Arrays.fill(d, INF);
//
//        // 다익스트라 알고리즘 수행
//        dijkstra(start);
//
//        // 모든 노드로 가기 위한 최단 거리 출력
//        for (int i = 1; i <= n; i++) {
//            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
//            if (d[i] == INF) {
//                System.out.println("INFINITY");
//            }
//            // 도달할 수 있는 경우 거리를 출력
//            else {
//                System.out.println(d[i]);
//            }
//        }
//    }
//
//
//}
