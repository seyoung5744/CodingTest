import java.util.*;

public class Solution {

    public static String[] alphabet = {"A", "E", "I", "O", "U"};
    public static List<String> words = new ArrayList<>();

    public static int solution(String word) {
        generate("");
        return words.indexOf(word);
    }

    public static void generate(String s) {
        words.add(s);
        if (s.length() == 5) {
            return;
        }

        for (int i = 0; i < alphabet.length; i++) {
            generate(s + alphabet[i]);
        }
    }
}
