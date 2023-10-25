import java.util.*;

public class Solution {
    public static int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for(int i = 1; i <= 26; i++) {
            dict.put( Character.toString(64 + i), i);
        }

        List<Integer> answer = new ArrayList<>();

        String key = msg.substring(0, 1);
        int iter = 0;
        while(true)
        {
            if (iter + 1 < msg.length())
            {
                String temp = key;
                temp += msg.charAt(iter + 1);

                if (dict.containsKey(temp))
                {
                    key = temp;
                }
                else
                {
                    answer.add(dict.get(key));
                    dict.put(temp, dict.size() + 1);
                    key = String.valueOf(msg.charAt(iter + 1));
                }

                ++iter;
            }
            else {
                answer.add(dict.get(key));
                break;
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
