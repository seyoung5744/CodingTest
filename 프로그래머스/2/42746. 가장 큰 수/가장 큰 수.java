import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());

        if (result.charAt(0) == '0') return "0";

        return result;
    }
}