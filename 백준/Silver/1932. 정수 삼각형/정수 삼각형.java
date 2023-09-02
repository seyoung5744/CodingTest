import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] triangle;
    public static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < tokens.length; j++) {
                triangle[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        dp[0][0] = triangle[0][0];
        for (int i = 0; i < N; i++) {
            maxValue(N - 1, i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(dp[N-1][i] > max){
                max = dp[N-1][i];
            }
        }
        System.out.println(max);
    }


    public static int maxValue(int floor, int index) {
        if (floor < 0 || index < 0 || index >= N) {
            return 0;
        }

        if (dp[floor][index] == null) {
            dp[floor][index] = triangle[floor][index] + Math.max(maxValue(floor - 1, index - 1), maxValue(floor - 1, index));

        }

        return dp[floor][index];
    }

}
