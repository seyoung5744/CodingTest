import java.util.*;

class Solution {
    public static String[] words = {"A", "E", "I", "O", "U"};
    public static List<String> result = new ArrayList<>();

    public static int solution(String word) {
        generate("");
        return result.indexOf(word);
    }

    public static void generate(String s) {
        result.add(s);
        if(s.length() == 5) return;
        for(String c : words) {
            generate(s + c);
        }
    }
}