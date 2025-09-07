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
        int count = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(heights);
        System.out.println(binary(count, heights));
        br.close();
    }

    private static int binary(int count, int[] heights) {
        int start = 0;
        int end = 1_000_000_001;

        while (start < end) {
            int mid = start + (end - start) / 2;

            int prev = heights[0];
            int remain = count - 1;
            for (int i = 1; i < heights.length; i++) {
                if (heights[i] - prev >= mid)
                {
                    remain--;
                    prev= heights[i];
                }

                if (remain == 0)
                    break;
            }

            if (remain == 0)
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }

        return end - 1;
    }
}
