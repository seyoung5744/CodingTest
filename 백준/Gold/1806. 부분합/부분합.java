import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;

        while (true) {
            if (sum >= target) {
                count = Math.min(count, right - left);
                sum -= nums[left++];
            } else if (right >= N) {
                break;
            } else {
                sum += nums[right++];
            }
        }

        count = count == Integer.MAX_VALUE ? 0 : count;
        System.out.println(count);

        bw.flush();
        br.close();
        bw.close();
    }
}
