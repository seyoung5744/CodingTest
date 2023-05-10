package 유형별_일고리즘_이론._10_그래프_이론;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
public class 커리큘럼 {
    // 노드의 개수(V)
    public static int v;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    public static int[] indegree = new int[501];
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 각 강의 시간을 0으로 초기화
    public static int[] times = new int[501];

    public static void topologySort(){
        int[] result = new int[501];
        for (int i = 1; i <= v ; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= v ; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            // 큐에서 원소 꺼내기
            int now = q.poll();
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                System.out.println(result[graph.get(now).get(i)] + ", " +  (result[now] + times[graph.get(now).get(i)]));
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력받기
        for (int i = 1; i <= v ; i++) {
            // 첫 번째 수는 시간 정보를 담고 있음
            int x = sc.nextInt();
            times[i] = x;
            // 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while(true){
                x = sc.nextInt();
                if(x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologySort();
    }

}
