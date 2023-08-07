import java.util.Arrays;
class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        
        return new StringBuffer(new String(cArr)).reverse().toString();
    }
}