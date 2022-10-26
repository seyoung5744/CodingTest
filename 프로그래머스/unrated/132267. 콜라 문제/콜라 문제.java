class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int rest = 0;
        while (n >= a) {
            rest = n % a;
            n = (n / a) * b;
            answer += n;
            n = n + rest;
        }
        return answer;
    }
}