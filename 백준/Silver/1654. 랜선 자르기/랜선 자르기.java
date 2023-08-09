import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lines = new int[k];

        int maxLine = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if (maxLine < lines[i]) {
                maxLine = lines[i];
            }
        }

        System.out.println(binarySearch(n, maxLine, lines));
    }

    public static long binarySearch(int target, int maxLine, int[] lines) {
        long start = 1;
        long end = maxLine;

        while (start <= end) {
            long mid = (end + start) / 2;
            long count = 0;

            for (int line : lines) {
                count += line / mid;
            }

            if (count < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start - 1;
    }

}
