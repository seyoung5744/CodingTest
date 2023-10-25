public class Solution {

    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        int decimal = 0;
        int order = 0;

        while (true) {
            String radix = Integer.toString(decimal, n).toUpperCase();

            for (char c : radix.toCharArray()) {
                if (order % m  == p - 1) {
                    answer += c;
                }
                if (answer.length() == t) {
                    break;
                }
                order++;
            }
            if (answer.length() == t) {
                break;
            }
            decimal++;
        }
        return answer;
    }

}
