import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] length = new int[n];

        int answer = -1;
        for (int k = 0; k < n; k++) {
            length[k] = 1;
            for (int i = 0; i < k; i++) {
                if (nums[i] < nums[k]) {
                    length[k] = Math.max(length[k], length[i] + 1);
                }
            }
            answer = Math.max(answer, length[k]);
        }

        System.out.println(answer);
        br.close();
    }
}
