public class Solution {

    public static final String[] words = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            if(s.contains(words[i])) {
                s = s.replace(words[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }

}