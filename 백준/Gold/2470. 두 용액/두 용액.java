import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 용액 개수

        st = new StringTokenizer(br.readLine());
        int[] solution = new int[N];
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;

        int a1 = 0;
        int a2 = 0;
        while (start < end) {
            int sum = solution[start] + solution[end];
            int abs = Math.abs(sum);
            if (abs < min) {
                min = abs;
                a1 = solution[start];
                a2 = solution[end];
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(a1 + " " + a2);

        bw.flush();
        br.close();
        bw.close();
    }

}
