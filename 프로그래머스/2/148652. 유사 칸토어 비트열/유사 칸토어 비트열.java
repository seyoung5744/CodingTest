public class Solution {

    public static int loop;
    public static String result;

    public static int solution(int n, long l, long r) {

        int answer = 0;
        int[] can = {1, 1, 0, 1, 1};
        for(long i = l - 1; i < r; ++i)
        {
            long idx = i;
            boolean flag = true;

            while(idx > 4)
            {
                long remain = idx % 5;

                idx /= 5;

                if (remain == 2)
                {
                    flag = false;
                    break;
                }
            }

            if (!flag)
                continue;
            
            answer += can[(int)idx];

        }
        return answer;
    }
}
