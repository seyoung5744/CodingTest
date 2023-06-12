import java.util.*;
import java.io.*;

public class Main {

    public static final int FIX_SIZE = 123_456 * 2 + 1;
    public static boolean[] prime = new boolean[FIX_SIZE];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        makePrime(FIX_SIZE);
        while (true) {
            n = sc.nextInt();

            if(n == 0){
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i]) {
                    count += 1;
                }
            }

            System.out.println(count);
        }
    }

    public static void makePrime(int n) {

        prime[0] = prime[1] = true;
        if (n < 2) {
            return;
        }

        /*
		소수가 아닌 index = true
		소수인 index = false
		*/

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= prime.length; j += i) {
                if (prime[j]) {
                    continue;
                }

                prime[j] = true;
            }
        }


    }

}
