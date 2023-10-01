import java.util.*;

public class Solution {

    public int solution(String numbers) {
        int[] numArr = numbers.chars().map(i -> i - '0').toArray();
        boolean[] isUsed = new boolean[numArr.length];
        Set<Integer> primes = new HashSet<>();
        
        getPrime(0, numArr, isUsed, primes);
        
        return primes.size();
    }
    
    public static void getPrime(int num, int[] numArr, boolean[] isUsed, Set<Integer> primes) {
        if(isPrime(num)) primes.add(num);

        for (int i = 0; i < numArr.length; i++) {
            if(isUsed[i]) continue;
            
            int nextNum = num * 10 + numArr[i]; 
            isUsed[i] = true;
            getPrime(nextNum, numArr, isUsed, primes);
            isUsed[i] = false;
        }
    }
    
    public static boolean isPrime(int num) {
        if(num <= 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }

}
