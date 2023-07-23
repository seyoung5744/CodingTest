import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        
        int[] nums = new int[n];
        for (int i = 0; i < strArr.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        
        int result = 0;

        while(start < end){
            int sum = nums[start] + nums[end];
           
            if(sum == x){
                result++;
                start++;
            }else if(sum > x){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(result);
    }

}
