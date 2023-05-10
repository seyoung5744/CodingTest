package 유형별_일고리즘_이론._05_DFS_BFS;

public class 인접_행렬 {

    private static final int INF = 999999999;

    // 2차원 햏려을 이용한 인접 행렬
    public static int[][] graph = {
        {0, 7, 5},
        {7, 0, INF},
        {5, INF, 0}
    };

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
