
import java.util.*;

public class Solution {

    public static Map<String, Integer> dictionary = new HashMap<>();

    public static int[] solution(String msg) {
        for (char i = 'A'; i <= 'Z'; i++) {
            dictionary.put(Character.toString(i), i - 'A' + 1);
        }

        List<Integer> answer = new ArrayList<>();
        String cur = "";

        for (int i = 0; i < msg.length(); i++) {
            cur += msg.charAt(i);

            if (!dictionary.containsKey(cur))
            {
                dictionary.put(cur, dictionary.size() + 1);
                answer.add(dictionary.get(cur.substring(0, cur.length() - 1)));
                cur = "";
                i--;
            }
        }
        
        if(cur.length() > 0)
            answer.add(dictionary.get(cur));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
