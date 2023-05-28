import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n+1];

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for (int j = a; j <=b ; j++) {
                nums[j] = c;
            }
        }

        for (int i = 1; i < n+1; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
