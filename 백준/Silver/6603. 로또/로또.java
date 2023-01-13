import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int k = 1;

        while (k != 0) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[k];

            combination(nums, visited, 0, k, 6);
            System.out.println();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void combination(int[] nums, boolean[] visited, int depth, int k, int r) {

        if (r == 0) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (depth == k) {
            return;
        }

        visited[depth] = true;
        combination(nums, visited, depth + 1, k, r - 1);

        visited[depth] = false;
        combination(nums, visited, depth + 1, k, r);
    }


}
