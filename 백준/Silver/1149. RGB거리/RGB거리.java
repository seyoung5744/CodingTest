import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    private static int[][] dp;
    private static int[][] rgb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        rgb = new int[n][3];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][RED] = Integer.parseInt(st.nextToken());
            rgb[i][GREEN] = Integer.parseInt(st.nextToken());
            rgb[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = rgb[0][RED];
        dp[0][GREEN] = rgb[0][GREEN];
        dp[0][BLUE] = rgb[0][BLUE];

        System.out.println(Math.min(paint(n-1, RED), Math.min(paint(n-1, GREEN), paint(n-1, BLUE))));
    }

    private static int paint(int n, int color) {

        if(dp[n][color] == 0) {
            switch (color) {
                case RED:
                    return dp[n][RED] = rgb[n][RED] + Math.min(paint(n - 1, GREEN), paint(n - 1, BLUE));
                case GREEN:
                    return dp[n][GREEN] =rgb[n][GREEN] + Math.min(paint(n - 1, RED), paint(n - 1, BLUE));
                case BLUE:
                    return dp[n][BLUE] =rgb[n][BLUE] + Math.min(paint(n - 1, GREEN), paint(n - 1, RED));
            }
        }

        return dp[n][color];
    }
}
