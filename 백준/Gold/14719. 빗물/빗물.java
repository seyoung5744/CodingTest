import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] bricks) {
        int[] leftMax = new int[bricks.length];
        int[] rightMax = new int[bricks.length];
        leftMax[0] = bricks[0];
        for (int i = 1; i < bricks.length; i++) {
            leftMax[i] = Math.max(bricks[i], leftMax[i - 1]);
        }

        rightMax[bricks.length - 1] = bricks[bricks.length - 1];
        for (int i = bricks.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(bricks[i], rightMax[i + 1]);
        }

        int result = 0;

        for (int i = 0; i < bricks.length; i++) {
            result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - bricks[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] bricks = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            bricks[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(bricks));
    }
}