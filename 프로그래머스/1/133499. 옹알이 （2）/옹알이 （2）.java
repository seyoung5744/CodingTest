import java.util.*;
import java.util.stream.*;

class Solution {
    public static final String[] CUR_BABBLING = {"aya", "ye", "woo", "ma"};
    public static final String[] EXCLUDE = {"ayaaya", "yeye", "woowoo", "mama"};
    
    public int solution(String[] babbling) {
        for (int i = 0; i < babbling.length; i++) {
            if (isExclude(babbling[i])) continue;
            
            for (String include : CUR_BABBLING) {
                babbling[i] = babbling[i].replace(include, " ");
            }
        }
        return (int)Arrays.stream(babbling)
            .filter(str -> str.isBlank())
            .count();
    }
    
    public boolean isExclude(String word) {
        for (String exclude : EXCLUDE) {
            if (word.contains(exclude)) return true;
        }
        return false;
    }
}