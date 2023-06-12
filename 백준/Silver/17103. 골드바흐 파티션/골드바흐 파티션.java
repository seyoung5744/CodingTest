import java.util.*;
import java.io.*;

public class Main {

    public static boolean[] prime = new boolean[1_000_000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        makePrime(1_000_000);

        while (T-- > 0) {
            int n = sc.nextInt();
            int cnt = 0;

            for (int i = 2; i < n; i++) {
                if (!prime[i] && !prime[n - i] && i <= n - i) {
                    cnt+=1;
                }
            }
            System.out.println(cnt);
        }
    }

    public static void makePrime(int n) {
        prime[0] = prime[1] = true;

        if (n < 2) {
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                if (prime[j]) {
                    continue;
                }
                prime[j] = true;
            }
        }

    }

}
