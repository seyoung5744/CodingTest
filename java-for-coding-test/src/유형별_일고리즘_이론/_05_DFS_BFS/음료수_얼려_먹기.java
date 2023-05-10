package 유형별_일고리즘_이론._05_DFS_BFS;

import java.util.Scanner;

/**
 15 14
 00000111100000
 11111101111110
 11011101101110
 11011101100000
 11011111111111
 11011111111100
 11000000011111
 01111111111111
 00000000011111
 01111111111000
 00011111111000
 00000001111000
 11111111110011
 11100011111111
 11100011111111
 */
public class 음료수_얼려_먹기 {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        // 현재 노드를 방문 처리
        if (graph[x][y] == 0) {
            graph[x][y] = 1;

            // 상, 하, 좌, 우 위치들로 모두 재귀적으로 호출
            dfs(x, y - 1);
            dfs(x, y + 1);
            dfs(x - 1, y);
            dfs(x + 1, y);
            return true;
        }

        return false;
    }

}
