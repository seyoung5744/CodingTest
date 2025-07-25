package _17_최단경로._38_정확한_순위;

import java.util.*;

/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
 */
public class Main {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M)
    public static int n, m;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) graph[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }


        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n ; a++) {
                for (int b = 1; b <= n ; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int result = 0;
        // 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n ; j++) {
                if(graph[i][j] != INF || graph[j][i] != INF){
                    cnt+=1;
                }
            }
            if(n == cnt){
                result += 1;
            }
        }

        System.out.println(result);
    }
}
