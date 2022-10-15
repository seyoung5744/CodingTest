class Solution {
    public long solution(int n) {
         // long answer = 0;
        int a = 1;
        int b = 2;
        if(n<=1)
            return 1;
        for (int i = 1; i <n ; i++) {
            int tmp = b;
            b = (a + b) % 1234567;
            a = tmp;
        }

        return a;
    }
}