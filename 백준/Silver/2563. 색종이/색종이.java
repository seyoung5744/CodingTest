import java.util.*;

public class Main {

    public static int[][] map = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    map[a][b] += 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if(map[i][j] > 0){
                    sum+=1;
                }
            }
        }

        System.out.println(sum);


    }

}
