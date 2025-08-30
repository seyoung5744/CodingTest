import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairCount = Integer.parseInt(br.readLine());
        int[] scores = new int[stairCount + 1];
        for (int i = 1; i < stairCount + 1; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[stairCount + 1];
        dp[1] = scores[1];

        if (stairCount > 1) {
            dp[2] = scores[1] + scores[2];
        }

        for (int i = 3; i < stairCount + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }
        System.out.println(dp[stairCount]);
        br.close();
    }
}
