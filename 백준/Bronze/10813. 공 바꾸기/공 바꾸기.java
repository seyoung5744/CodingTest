import java.util.*;

public class Main {
    public static int[] nums = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n+1; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            swap(a, b);
        }

        for (int i = 1; i < n+1; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void swap(int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
