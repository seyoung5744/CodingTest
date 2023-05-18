package _17_최단경로._39_화성탐사;

import java.util.*;

/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
 */

class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance < o.distance) {
            return -1;
        }

        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    public static int[][] graph = new int[125][125];
    public static int[][] d = new int[125][125];
    public static int testCase, n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();
        while(testCase-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }

            int x = 0, y = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(x, y, graph[x][y]));
            d[x][y] = graph[x][y];

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int distance = now.getDistance();
                x = now.getX();
                y = now.getY();

                if (d[x][y] < distance) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        int cost = distance + graph[nx][ny];

                        if (cost < d[nx][ny]) {
                            d[nx][ny] = cost;
                            pq.offer(new Node(nx, ny, cost));
                        }
                    }
                }
            }

            System.out.println(d[n-1][n-1]);
        }


    }

}
