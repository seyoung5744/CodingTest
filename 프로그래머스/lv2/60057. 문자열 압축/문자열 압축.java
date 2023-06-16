import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length() / 2 + 1; length++) {
            int compressed = compress(s, length);
            if(min > compressed) min = compressed;
        }

        return min;
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if(endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();
        String pre = "";
        int count = 0;
        for(String token : split(source, length)){
            // 압축 문자열 구성
            if(token.equals(pre)){
                count++;
            }else{
                if(count > 1) sb.append(count);
                sb.append(pre);
                pre = token;
                count = 1;
            }
        }

        if(count > 1) sb.append(count);
        sb.append(pre);
        return sb.length();
    }
}