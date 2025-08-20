import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][RED] = Integer.parseInt(st.nextToken());
            rgb[i][GREEN] = Integer.parseInt(st.nextToken());
            rgb[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            rgb[i][RED] += Math.min(rgb[i - 1][GREEN], rgb[i - 1][BLUE]);
            rgb[i][GREEN] += Math.min(rgb[i - 1][RED], rgb[i - 1][BLUE]);
            rgb[i][BLUE] += Math.min(rgb[i - 1][RED], rgb[i - 1][GREEN]);
        }
        int answer = Math.min(rgb[N][RED], Math.min(rgb[N][GREEN], rgb[N][BLUE]));
        System.out.println(answer);
        br.close();
    }
}
