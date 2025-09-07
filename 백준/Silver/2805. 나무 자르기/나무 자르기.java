import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxHeight = -1;
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, heights[i]);
        }

        System.out.println(binary(maxHeight, target, heights));
        br.close();
    }

    private static int binary(int end, int target, int[] heights) {
        int start = 0;

        while (start < end) {
            int mid = start + (end - start) / 2;

            long sum = 0;
            for (int i = heights.length - 1; i >= 0; i--) {
                if (heights[i] <= mid) continue;
                sum += heights[i] - mid;
            }

            if (sum < target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end - 1;
    }
}
