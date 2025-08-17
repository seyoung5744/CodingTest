import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        for (int coin : coins) {
            if (target == 0) break;
            if (coin > target) {
                continue;
            }
            answer += target / coin;
            target %= coin;
        }
        System.out.println(answer);
        br.close();
    }
}
