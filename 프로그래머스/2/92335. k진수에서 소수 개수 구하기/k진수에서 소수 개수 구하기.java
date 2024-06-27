public class Solution {

    public static int solution(int n, int k) {
        int answer = 0;
        
        String[] candidate = Integer.toString(n, k).split("0");
        for(String num : candidate) {
            if(num.length() == 0) continue;
            if(isPrime(Long.parseLong(num))) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
