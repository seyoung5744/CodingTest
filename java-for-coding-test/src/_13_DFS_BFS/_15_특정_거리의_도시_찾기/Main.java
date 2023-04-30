package _13_DFS_BFS._15_특정_거리의_도시_찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
4 4 2 1
1 2
1 3
2 3
2 4
 */
public class Main {

    // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 모든 도시에 대한 최단 거리 초기화
    public static int[] d = new int[300001];

    // 너비 우선 탐색(BFS) 수행
    public static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 출발 도시까지의 거리는 0으로 설정
        d[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                // 아직 방문하지 않은 도시라면
                if (d[nextNode] == -1) {
                    // 최단 거리 갱신
                    q.add(nextNode);
                    d[nextNode] = d[now] + 1;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // 그래프 및 최단 거리 테이블 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }
        // 모든 도로 정보 입력 받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        bfs(x);

        // 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        // 만약 최단 거리가 K인 도시가 없다면, -1 출력
        if (!flag) {
            System.out.println(-1);
        }

    }

}
