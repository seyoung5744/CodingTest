public class Solution {

    public static int solution(String s) {
        int answer = 0;

        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start < s.length(); start++) {

                int end = start + length -1;
                
                if (end >= s.length()) {
                    break;
                }
                if(isPalindrom(start, end, s)) {
                    return length;
                }
            }
        }
        return answer;
    }

    public static boolean isPalindrom(int start, int end, String s) {

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
