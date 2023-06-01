import java.util.*;
import java.io.*;

public class Main {

    public static int[] nums = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        if (nums[2] < nums[0] + nums[1]) {
            System.out.println(Arrays.stream(nums).sum());
        } else {
            System.out.println(2 * (nums[0] + nums[1]) - 1);
        }
    }

}
