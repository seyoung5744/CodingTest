import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strings = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        String answer = Arrays.stream(strings)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}