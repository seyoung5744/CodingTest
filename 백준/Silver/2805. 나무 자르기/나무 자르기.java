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

        int maxLen = -1;
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            if(maxLen < heights[i]){
                maxLen = heights[i];
            }
        }

        System.out.println(binarySearch(heights, target, maxLen));
        br.close();
    }

    private static int binarySearch(int[] nums, int target, int maxLen){
        int start = 0;
        int end = maxLen;

        while(start < end){
            int mid = (end + start) / 2;
            long count = 0;
            for(int num : nums){
                if(num > mid) {
                    count += num - mid;
                }
            }

            if(count < target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end - 1;
    }
}
