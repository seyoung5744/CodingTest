import java.io.*;
import java.util.*;

public class Main {

    public static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (max < num) {
                    max = num;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(a + " " + b);
    }

}
