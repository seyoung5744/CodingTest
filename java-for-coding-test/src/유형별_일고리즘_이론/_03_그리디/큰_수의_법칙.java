package 유형별_일고리즘_이론._03_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰_수의_법칙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int first = nums[N - 1];
        int second = nums[N - 2];
        int sum = 0;

//        while(true){
//            for (int i = 0; i < K; i++) {
//                if(M == 0){
//                    break;
//                }
//                sum += first;
//                M--;
//            }
//            if(M == 0){
//                break;
//            }
//            sum += second;
//            M--;
//        }

        int count = (int) (M / (K + 1)) * K;
        count += M % (K + 1);

        sum += count * first;
        sum += (M - count) * second;


        System.out.println(sum);

    }

}
