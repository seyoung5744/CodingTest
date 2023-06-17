import java.io.*;
import java.util.*;

public class Main {

    public static int count;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void hanoi(int n, int from, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty);
        hanoi(1, from, to);
        hanoi(n - 1, empty, to);
    }

}
