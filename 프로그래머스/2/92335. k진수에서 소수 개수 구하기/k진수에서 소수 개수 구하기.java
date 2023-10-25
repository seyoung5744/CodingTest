import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int solution(int n, int k) {
        int answer = 0;
        String radix = Integer.toString(n, k);

        String[] split = radix.split("0");

        for(String s : split) {
            if(s.equals("")){
                continue;
            }
            if(isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean isPrime(long num) {
        if(num < 2){
            return false;
        }

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
