import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).split("0");
        for (String num : arr) {
            if (num.length() == 0) continue;
            if (isPrime(Long.parseLong(num))) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num < 2) return false;
        
        for (long i = 2; i * i<= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}