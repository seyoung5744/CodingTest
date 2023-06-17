import java.util.*;
import java.io.*;

public class Main {

    public static char[] arr;
    public static int n, cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while((str = br.readLine()) != null && !str.isEmpty()) {
            n = Integer.parseInt(str);
            cnt = (int) Math.pow(3, n);
            arr = new char[cnt];

            Arrays.fill(arr, '-');

            dfs(0, cnt);

            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }

    public static void dfs(int start, int length) {
        if (length == 1) {
            return;
        }

        for (int i = start + length / 3; i < start + length / 3 * 2; i++) {
            arr[i] = ' ';
        }

        dfs(start, length / 3);
        dfs(start + length / 3 * 2, length / 3);
    }


}
