import java.util.*;

class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] cArr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int idx : index_list) {
            sb.append(cArr[idx]);
        }
        
        return sb.toString();
    }
}