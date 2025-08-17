import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i < N; i++) {
            int sum = distributionSum(i);
            if (sum == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
        br.close();
    }

    public static int distributionSum(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
