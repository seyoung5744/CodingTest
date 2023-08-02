import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int compress = compress(s, length);
            if (compress < min) {
                min = compress;
            }
        }
        return min;
    }

    private static List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) {
                endIndex = source.length();
            }
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private static int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count += 1;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);

        return sb.length();
    }
}