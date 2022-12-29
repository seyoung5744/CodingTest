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

        long answer = 0;

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        long left = 1;
        long right = 0;
                
        int[] lans = new int[N];
        for (int i = 0; i < N; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            right = Math.max(lans[i], right);
        }
        

        while (left <= right) {
            long mid = left + (right - left) / 2;

            int count = 0;

            for (int lan : lans) {
                count += (lan / mid);
            }

            if (count >= M) {
                answer = Math.max(mid, answer);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
