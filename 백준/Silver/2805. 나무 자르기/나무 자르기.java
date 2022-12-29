import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // 높이를 domain으로
        long left = 0;
        long right = 0;

        int[] heights = new int[N];
        String[] strHeight = br.readLine().split(" ");

        for (int i = 0; i < strHeight.length; i++) {
            heights[i] = Integer.parseInt(strHeight[i]);
            right = Math.max(heights[i], right);
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long length = 0; // 가져갈 나무 길이
            for (long wood : heights) {
                if (wood >= mid) {
                    length += wood - mid;
                }
            }
            if (length >= M) { // 짤린 길이가 가져가려는 것보다 더 길면 높혀야함
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(right + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
