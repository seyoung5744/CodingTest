import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> appearedWords = new HashSet<>();
        appearedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (appearedWords.contains(words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }

            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            appearedWords.add(words[i]);
        }

        return new int[]{0, 0};
    }
}