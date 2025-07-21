class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        // 1 2 3 4 5 6 7 8
        //  1   2   3   4
        //    1       2
        while (n > 1) {
            a =  (a + 1) / 2;
            b =  (b + 1) / 2 ;
            if (a == b) {
                break;
            }
            answer++;
            n /= 2;
        }
        
        return answer;
    }
}