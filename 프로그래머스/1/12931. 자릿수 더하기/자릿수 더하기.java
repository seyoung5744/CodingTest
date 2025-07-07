public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            int digit = n % 10;
            answer += digit;
            n /= 10;
        }
        return answer;
    }
}