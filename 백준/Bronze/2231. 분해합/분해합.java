import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;

        int start = (int) Math.pow(10, (int) (Math.log10(N) + 1) - 1);

        for (int i = 0; i < N; i++) {
            int num = i;
            int digit = (int) (Math.log10(num) + 1); // 자리수
            int sum = 0;
            for (int j = 0; j < digit; j++) {
                sum += (num % 10);
                num /= 10;
            }
            if (i + sum == N) {
                answer = Math.min(answer, i);
            }
        }

        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }

        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
