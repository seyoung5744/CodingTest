import java.util.*;

public class Main {

    public static int n;
    public static int[] dp = new int[2000];
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        Collections.reverse(list);

        for (int k = 0; k < n; k++) {
            dp[k] = 1;

            for (int i = 0; i < k; i++) {
                if (list.get(i) < list.get(k)) {
                    dp[k] = Math.max(dp[k], dp[i] + 1);
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }

}
