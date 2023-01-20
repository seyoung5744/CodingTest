import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int maxScore = maxScore(scores);
        double sum = 0;
        for (int score : scores) {
            sum += (double) score / maxScore * 100;
        }
        System.out.println(sum / n);
        
        bw.flush();
        br.close();
        bw.close();
    }

    public static int maxScore(int[] scores) {
        int max = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }
}
