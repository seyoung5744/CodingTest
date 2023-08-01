import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        int answer = Integer.MAX_VALUE;

        int i = 0;
        int count = 5;
        while(i < nums.size()){

            int num = nums.get(i);
            int cnt = 0;
            while (cnt < 5){
                if(nums.contains(num++)) count -= 1;
                cnt++;
            }

            answer = Math.min(answer, count);
            count = 5;
            i++;
        }

        System.out.println(answer);

    }

}
