import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(start < end){
            int sum = nums[start] + nums[end];
            int abs = Math.abs(sum);

            if(abs < min){
                min = abs;
                result[0] = nums[start];
                result[1] = nums[end];
            }

            if(sum < 0){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

}
