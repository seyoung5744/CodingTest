public class Solution {

    public static int solution(String s) {
        int answer = 0;

        for (int length = s.length(); length > 0; length--) {
            for (int i = 0; i < s.length(); i++) {

                if (i + length > s.length()) {
                    break;
                }
                if(isPalindrom(i, i + length, s)) {
                    return length;
                }
            }
        }
        return answer;
    }

    public static boolean isPalindrom(int start, int end, String s) {
        int left = start;
        int right = end - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
