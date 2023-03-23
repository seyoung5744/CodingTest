import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] sumArr = new int[N + 1];

        long answer = 0;
        for (int i = 1; i < N + 1; i++) {
            int idx = 1;
            while (i * idx < N + 1) {
                sumArr[i * idx] += i;
                idx++;
            }
            answer += sumArr[i];
        }

        bw.write(answer+"");

        bw.flush();
        br.close();
        bw.close();
    }
}
