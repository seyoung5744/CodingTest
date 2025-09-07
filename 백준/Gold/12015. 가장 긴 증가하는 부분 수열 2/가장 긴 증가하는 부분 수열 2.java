import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(LIS(nums));

        br.close();
    }

    public static int LIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int idx = getPosition(lis, num);

            if (idx >= lis.size())
                lis.add(num);
            else {
                lis.set(idx, num);
            }
        }

        return lis.size();
    }

    public static int getPosition(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (target <= list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


}
