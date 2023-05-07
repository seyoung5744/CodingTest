import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int[][] rooms = new int[15][15];

            int k = sc.nextInt();
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                rooms[0][i] = i;
            }
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int l = 1; l <= j ; l++) {
                        rooms[i][j] += rooms[i-1][l];
                    }
                }
            }
            
            System.out.println(rooms[k][n]);
        }
    }
}
