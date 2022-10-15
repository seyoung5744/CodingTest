class Solution {
    public long solution(int n) {
        int answer = 0;
        int a = 1;
        int b = 2;

        if(n<=1)
            return 1;
        for (int i = 1; i <n ; i++) {
            answer = b;
            b = (a + b) % 1234567;
            a = answer;
        }

        return answer;
    }
}