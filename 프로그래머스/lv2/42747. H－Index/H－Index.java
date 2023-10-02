import java.util.Arrays;

public class Solution {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = citations.length; i >= 1; i--) {
            if(isValid(citations, i)) return i;
        }
        return answer;
    }
    
    public static boolean isValid(int[] citations, int h) {
        int idx = citations.length - h;
        return citations[idx] >= h;
    }

}
