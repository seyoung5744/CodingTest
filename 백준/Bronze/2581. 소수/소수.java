import java.util.*;

public class Main {

    public static boolean[] prime; // 소수를 체크할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        makePrime(m);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = n; i <= m; i++) {
            if(!prime[i]){
                sum += i;
                min = Math.min(min, i);
            }
        }
        if(sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        }else{
            System.out.println("-1");
        }
    }

    public static void makePrime(int n) {
        prime = new boolean[n+1];

        /*
		소수가 아닌 index = true
		소수인 index = false
		*/
        prime[0] = prime[1] = true;
        
        if(n < 2){
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]){
                continue;
            }

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
