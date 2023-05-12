import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int v = sc.nextInt();

        int sum = (int)Arrays.stream(nums).filter(x -> x==v).count();
        System.out.println(sum);
    }
}