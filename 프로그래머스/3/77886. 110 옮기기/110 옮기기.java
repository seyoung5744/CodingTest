import java.util.Arrays;

public class Solution {

    public static final String TOKEN = "110";

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            StringBuilder str = new StringBuilder(s[i]);
            StringBuilder temp = new StringBuilder();

            int count = 0;

            for(int j = 0; j < str.length(); ++j)
            {
                temp.append(str.charAt(j));
                if(temp.length() >= 3) {
                    int length = temp.length();
                    if(temp.charAt(length - 1) == '0' && temp.charAt(length - 2) == '1' && temp.charAt(length -3) == '1') {
                        temp = temp.delete(length - 3, length);
                        ++count;
                    }
                }
            }

            int cur = temp.length() - 1;

            while(cur >= 0 && temp.charAt(cur) == '1')
            {
                --cur;
            }

            ++cur;

            answer[i] = temp.insert(cur, TOKEN.repeat(count)).toString();;
        }
        return answer;
    }

    public static int findToken(String s, int startIdx)
    {

        for(int i = startIdx; i < s.length() - 2; ++i)
        {
            if (s.charAt(i) == '1' && s.charAt(i+1) == '1' && s.charAt(i+2) == '0')
                return i;
        }

        return -1;
    }


}
