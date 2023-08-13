import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] dp;
    private static int[] arr;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        max(n - 1);

        bw.write(max + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int max(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(max(n - 1) + arr[n], arr[n]);

            max = Math.max(dp[n], max);
        }

        return dp[n];
    }
}
