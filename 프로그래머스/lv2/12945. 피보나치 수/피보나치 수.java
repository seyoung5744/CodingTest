class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        int temp = 0;
        if(n <= 1){
            return n;
        }
        for (int i = 1; i < n; i++) {
            temp = a+b;
            a = b  % 1234567;
            b = temp  % 1234567;

        }

        return temp % 1234567;
    }
}