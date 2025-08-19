import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairCount = Integer.parseInt(br.readLine());
        int[] scores = new int[stairCount + 1];
        for (int i = 1; i <= stairCount; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[stairCount + 1];
        dp[1] = scores[1];

        if (stairCount >= 2) {
            dp[2] = scores[1] + scores[2];
        }
        // 6 10 20 15 25 10 20
        for (int i = 3; i <= stairCount; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        }

        System.out.println(dp[stairCount]);
        br.close();
    }
}
