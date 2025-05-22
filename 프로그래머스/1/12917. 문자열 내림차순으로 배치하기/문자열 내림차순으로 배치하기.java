import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> chars = s.chars()
                .boxed()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int c : chars) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}