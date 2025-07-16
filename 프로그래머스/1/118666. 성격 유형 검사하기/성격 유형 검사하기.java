import java.util.*;

class Solution {
    public static final int[] SCORES = {3, 2, 1, 0, 1, 2, 3};

    public final Map<Character, Integer> personality = new HashMap<>() {{
        put('R', 0);
        put('T', 0);
        put('C', 0);
        put('F', 0);
        put('J', 0);
        put('M', 0);
        put('A', 0);
        put('N', 0);
    }};

    public char compare(char p1, char p2) {
        if (personality.get(p1) > personality.get(p2)) {
            return p1;
        } else if (personality.get(p1) < personality.get(p2)) {
            return p2;
        } else {
            return p1 > p2 ? p2 : p1;
        }
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            if (choices[i] < 4) {
                personality.put(disagree, personality.get(disagree) + SCORES[choices[i] - 1]);
            } else if (choices[i] > 4) {
                personality.put(agree, personality.get(agree) + SCORES[choices[i] - 1]);
            }
        }

        answer += compare('R', 'T');
        answer += compare('C', 'F');
        answer += compare('J', 'M');
        answer += compare('A', 'N');
        return answer;
    }
}