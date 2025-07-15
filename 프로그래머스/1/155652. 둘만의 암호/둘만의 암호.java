import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Integer> skipSet = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            skipSet.add(skip.charAt(i) - 'a');
        }

        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            int loop = index;

            while (loop > 0) {
                pos = (pos  + 1) % ('z' - 'a' + 1);
                if (skipSet.contains(pos)) {
                    continue;
                }
                loop--;
            }
            answer += (char)(pos % ('z' - 'a' + 1) + 'a');
        }
        return answer;
    }
}