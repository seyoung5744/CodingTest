import java.io.*;
import java.util.*;

public class Main {

    public static int[] nums;
    public static int[] aliquots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        aliquots = new int[n - 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (i > 0) {
                aliquots[i - 1] = nums[i] - nums[i - 1];
            }
        }

        int ali = arrGcd(aliquots);

        int answer = 0;
        for (int i = 0; i < aliquots.length; i++) {
            answer += aliquots[i] / ali - 1;
        }

        System.out.println(answer);
    }

    public static int arrGcd(int[] arr) {
        int result = arr[0];
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                result = gcd(arr[i], result);
            }
        }

        return result;
    }

    public static int gcd(int a, int b) {
        int num1 = a;
        int num2 = b;
        while (num2 > 0) {
            int tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }

        return num1;
    }

}
