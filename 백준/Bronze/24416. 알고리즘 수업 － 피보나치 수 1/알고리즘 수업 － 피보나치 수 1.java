import java.util.Scanner;

public class Main {

    public static int[] dp;
    public static int cnt1, cnt2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[n + 1];
        fibo(n);
        fibo2(n);
        System.out.println(cnt1 + " " + cnt2);
    }

    public static int fibo(int n) {
        if (n <= 2) {
            cnt1 += 1;
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static int fibo2(int n) {
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            cnt2 += 1;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
