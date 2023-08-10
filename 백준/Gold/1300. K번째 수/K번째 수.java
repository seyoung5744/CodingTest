import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        bw.write(binarySearch(n, k) + "");
        
        bw.flush();
        bw.close();
        br.close();
    }

    private static long binarySearch(int n, int k) {
        long start = 1;
        long end = k;

        while (start < end) {
            long mid = (end + start) / 2;
            long count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (k <= count) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

}
