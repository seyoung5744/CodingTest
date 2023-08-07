import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        int[] numArr = numbers.chars().map(i -> i - '0').toArray();
        boolean[] isUsed = new boolean[numArr.length];
        Set<Integer> primes = new HashSet<>();
        
        getPrime(0, numArr, isUsed, primes);
        return primes.size();
    }

    private static void getPrime(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes){
        if(isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {
            if(isUsed[i]) continue;
            
            int nextAcc = acc * 10 + numbers[i];
            isUsed[i] = true;
            getPrime(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    private static boolean isPrime(int num){
        if(num <= 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
