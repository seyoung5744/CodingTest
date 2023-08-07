import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
            .collect(Collectors.joining())
            .replaceAll("^0+","0");
    }
}