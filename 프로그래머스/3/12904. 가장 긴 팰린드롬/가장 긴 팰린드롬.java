public class Solution {
    public static int solution(String s)
    {
        for(int length = s.length(); length >= 1; --length)
        {
            for(int start = 0; start <= s.length() - length; ++start)
            {
                if(check(s, start, start + length - 1)) {
                    return length;
                }
            }
        }
        return 1;
    }

    public static boolean check(String s, int start, int end) {
        int left = start;
        int right = end;

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
