import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int maxLen = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(maxLen < nums[i]){
                maxLen = nums[i];
            }
        }

        //bw.write(binarySearch(nums, target, maxLen) + "");
        System.out.println(binarySearch(nums, target, maxLen));
        
        //bw.flush();
        //bw.close();
        //br.close();
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
