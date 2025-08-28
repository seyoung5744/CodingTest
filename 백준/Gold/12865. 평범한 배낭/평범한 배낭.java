import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Stuff {

        int weight;
        int value;

        public Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Stuff[] stuffs = new Stuff[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            stuffs[i] = new Stuff(w, v);
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (j < stuffs[i - 1].weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuffs[i - 1].weight] + stuffs[i - 1].value);
                }
            }
        }

        System.out.println(dp[n][k]);
        br.close();
    }
}
