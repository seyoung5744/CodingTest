public class Solution {

    public static int answer = 0;

    public static int solution(int n) {
        func(0, 0, n);
        return answer;
    }

    public static void func(int left, int right, int n)
    {
        if (left == n && right == n)
        {
            ++answer;
            return;
        }
        if (left < n)
        {
            func(left + 1, right, n);
        }

        if (right < left)
        {
            func(left, right + 1, n);
        }
    }
}
