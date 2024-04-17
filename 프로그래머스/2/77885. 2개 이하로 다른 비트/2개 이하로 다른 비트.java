import java.util.Arrays;

public class Solution {

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for (long number : numbers) {

            if (number % 2 == 0)
            {
                answer[idx++] = number + 1;
                continue;
            }

            String originBits = Long.toString(number, 2);
            originBits = '0' + originBits;
            char[] next = originBits.toCharArray();
            for(int i = next.length - 1; i > 0; --i)
            {
                if (next[i-1] == '0')
                {
                    next[i-1] = '1';
                    next[i] = '0';
                    break;
                }
            }

            answer[idx++] = Long.parseLong(String.valueOf(next), 2);
        }

        return answer;
    }
}
