import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://st-lab.tistory.com/104
public class Main {

    public static int[] arr = new int[10_001]; // 수열의 원소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                bw.write(i + "\n");
            }
        }

        br.close();
        bw.close();
    }

}
