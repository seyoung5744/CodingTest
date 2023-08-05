import java.util.Arrays;

public class Solution {

    private static final String[] CUR_BABBLING = {"aya", "ye", "woo", "ma"};
    private static final String[] EXCLUDE = {"ayaaya", "yeye", "woowoo", "mama"};

    public int solution(String[] babbling) {

        for (int i = 0; i < babbling.length; i++) {
            if(!isExclude(babbling[i])) continue;

            for(String include : CUR_BABBLING){
                babbling[i] = babbling[i].replace(include, " ");
            }
        }

        return (int) Arrays.stream(babbling)
            .filter(String::isBlank)
            .count();
    }

    private static boolean isExclude(String str) {
        for(String exclude : EXCLUDE){
            if(str.contains(exclude)) return false;
        }
        return true;
    }
}
