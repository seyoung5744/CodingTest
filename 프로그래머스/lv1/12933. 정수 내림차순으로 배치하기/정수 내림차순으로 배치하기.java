import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String result = "";
        String[] str = Long.toString(n).split("");

        Arrays.sort(str, Collections.reverseOrder());
        for (String s : str) result += s;
        return Long.parseLong(result);
    }
}