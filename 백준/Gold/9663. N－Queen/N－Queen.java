import java.util.Scanner;

public class Main {

    public static int[] map;
    public static int count, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N];
        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[depth] = i;

            if(isPossibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean isPossibility(int col) {
        for (int i = 0; i < col; i++) {
            if(map[i] == map[col]){
                return false;
            }else if(Math.abs(i - col) == Math.abs(map[i] - map[col])){
                return false;
            }
        }
        return true;
    }
}