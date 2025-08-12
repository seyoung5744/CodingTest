import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n];
        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 1;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for (int target : targets) {
            while (cur <= target) {
                stack.push(cur++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

        br.close();
    }
}
