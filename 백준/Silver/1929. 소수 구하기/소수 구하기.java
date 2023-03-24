import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        makePrime(N);

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
        br.close();
    }

    public static void makePrime(int N) {
        prime = new boolean[N + 1];

       /*
		소수가 아닌 index = true
		소수인 index = false
		*/

        // 2 미만의 N 을 입력받으면 소수는 판별할 필요 없으므로 바로 return
        if (N < 2) {
            return;
        }

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i] == true) {
                continue;
            }

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }

        }
    }

}
