class Solution {
    public int solution(int n, long l, long r) {
       int answer = 0;
        long div = (long)Math.pow(5.0, n - 1);

        for(long i = l - 1; i < r; ++i)
        {
            long num = i;
            long temp = div;
            while(num >= 5)
            {
                if (num / temp == 2) {
                    num = 2;
                    break;
                }

                num %= temp;
                temp /= 5;
            }

            if (num % 5 == 2)
                continue;

            answer++;
        }

        return answer;
    }
}