import java.util.*;

public class Main {

    public static boolean[] prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            long num = sc.nextLong();

            while (!isPrime(num)) {
                num++;
            }
            
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0){
                    return false;
                }
            }
        }
        return true;
    }

}
