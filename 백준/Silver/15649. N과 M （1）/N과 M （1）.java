import java.util.*;

public class Main {

    public static boolean[] visited;
    public static int[] arr;
    public static int n, m, depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n];
        arr = new int[m];
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}
