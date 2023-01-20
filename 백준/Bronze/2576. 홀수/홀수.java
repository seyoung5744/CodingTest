import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int oddSum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 != 0) {
                oddSum += num;
                if (num < min) {
                    min = num;
                }
            }
        }

        if (oddSum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(oddSum);
            System.out.println(min);

        }

        bw.flush();
        br.close();
        bw.close();
    }
}
