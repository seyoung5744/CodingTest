import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        Arrays.sort(str, Comparator.reverseOrder());

        return String.join("",str);
    }
}