import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Point {

        int fromTop;
        int fromLeft;
        int type;

        public Point(int type) {
            this.type = type;
        }
    }

    static int MOD = 20170805;

    public static final int[] dx = {1, 0}; // 우, 하
    public static final int[] dy = {0, 1};
    public static Point[][] graph;

    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        graph = new Point[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new Point(cityMap[i][j]);
            }
        }

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) {
                break;
            } else {
                graph[i][0].fromTop = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == 1) {
                break;
            } else {
                graph[0][i].fromLeft = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (graph[i][j].type == 1) {
                    continue;
                }

                graph[i][j].fromLeft = graph[i][j - 1].fromLeft;
                if (graph[i][j - 1].type != 2) {
                    graph[i][j].fromLeft = (graph[i][j].fromLeft + graph[i][j - 1].fromTop) % MOD;
                }

                graph[i][j].fromTop = graph[i - 1][j].fromTop;
                if (graph[i - 1][j].type != 2) {
                    graph[i][j].fromTop = (graph[i][j].fromTop + graph[i - 1][j].fromLeft) % MOD;
                }
            }
        }

        answer = (graph[m - 1][n - 1].fromLeft + graph[m - 1][n - 1].fromTop) % MOD;

        return answer;
    }
}
