import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int min;
    static int max;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        visited = new boolean[N - 1];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        char[] operator = new char[N - 1];
        char[] out = new char[N - 1];
        int idx = 0;

        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                if (i == 0) {
                    operator[idx] = '+';
                } else if (i == 1) {
                    operator[idx] = '-';
                } else if (i == 2) {
                    operator[idx] = '*';
                } else {
                    operator[idx] = '/';
                }
                idx += 1;
            }
        }

        permutation(operator, out, N - 1, N - 1, 0);

        System.out.println(max);
        System.out.println(min);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void permutation(char[] operator, char[] out, int n, int r, int depth) {
        if (depth == r) {
            int answer = calculator(out, n);
            min = Math.min(min, answer);
            max = Math.max(max, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = operator[i];
                permutation(operator, out, n, r, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int calculator(char[] operator, int N) {
        int answer = nums[0];
        for (int i = 1; i < N + 1; i++) {
            if (operator[i - 1] == '+') {
                answer += nums[i];
            } else if (operator[i - 1] == '-') {
                answer -= nums[i];
            } else if (operator[i - 1] == '*') {
                answer *= nums[i];
            } else if (operator[i - 1] == '/') {
                answer /= nums[i];
            }
        }

        return answer;
    }
}