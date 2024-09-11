
import java.util.Arrays;

public class Solution {

    public static String remove110(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if(answer.length() >= 2) {
                if (c == '0' ) {
                    if (answer.charAt(answer.length() - 1) == '1' && answer.charAt(answer.length() - 2) == '1' ) {
                        answer.delete(answer.length() - 2, answer.length());
                        continue;
                    }
                }
            }

            answer.append(c);
        }
        return answer.toString();
    }

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int x = 0; x < s.length; x++) {
            String str = s[x];
            String temp = remove110(str);

            StringBuilder result = new StringBuilder(temp);

            int count = (str.length() - temp.length()) / 3;

            int target = 0;

            while (target < temp.length()) {
                if (temp.charAt(target) == '1' ) {
                    if (target + 1 >= temp.length() || temp.charAt(target + 1) == '1' ) {
                        break;
                    }
                }

                ++target;
            }

            result.insert(target, "110".repeat(count));
            answer[x] = result.toString();
        }
        return answer;
    }
}
