import java.util.Scanner;

public class Main {

    public static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new char[n][n];

        recursion(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void recursion(int x, int y, int n, boolean black) {
        if (black) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;
        int count = 0;

        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count += 1;
                if (count == 5) {
                    recursion(i, j, size, true);
                } else {
                    recursion(i, j, size, false);
                }
            }
        }
    }

}
