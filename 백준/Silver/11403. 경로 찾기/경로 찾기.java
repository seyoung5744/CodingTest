import java.util.*;

public class Main {
    public static int INF = (int)1e9;
    public static int v, e;
    public static int[][] graph = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < 100; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if(num == 1) {
                    graph[i][j] = num;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == INF){
                    System.out.print("0 ");
                }else{
                    System.out.print("1 ");
                }

            }
            System.out.println();
        }
    }

}
