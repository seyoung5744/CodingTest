import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int loop = N;
        int cur = 0;
        while (loop-- > 0) {
            int count = K;
            while (count > 0) {
                if (nums[cur % N] != -1) {
                    count--;
                }
                cur++;
            }
            sb.append(nums[(cur - 1) % N]);
            if (loop > 0) {
                sb.append(",");
                sb.append(" ");
            }
            nums[(cur - 1) % N] = -1;
        }
        sb.append(">");
        System.out.println(sb);


        br.close();
    }
}
