import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 제한 시간 : 0.5초 -> 1초에 1억 연산을 가정한다면 완전탐색은 불가능

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        int start = 0;
        int end = 0;

        while (start <= end) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += nums[i];
            }

            if (sum > M) {
                start++;
            } else if (sum == M) {
                start++;
                count++;
            } else if (end == N) {
                break;
            } else {
                end++;
            }
        }

        System.out.println(count);
        bw.flush();
        br.close();
        bw.close();
    }

}
