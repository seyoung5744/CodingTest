import java.util.*;

class Solution {
    
    private static final String[] alphabet = {"A", "E", "I", "O", "U"};
    private static List<String> words = new ArrayList<>();
    
    public int solution(String word) {
        generate("");
        return words.indexOf(word);
    }
    
    private void generate(String s) {
        words.add(s);
        if (s.length() > 4) {
            return;
        }
        
        for (String word : alphabet) {
            generate(s + word);
        }
    }
}