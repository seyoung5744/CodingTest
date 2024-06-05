import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<String, Integer> m = new HashMap<>();
    public static int result = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            m.put(words[i], i);
        }
        find(new StringBuilder(begin),  0, new boolean[words.length], target);
        return result == Integer.MAX_VALUE? 0 : result;
    }

    public static void find(StringBuilder str, int count, boolean[] visited, String target) {

        if(str.toString().equals(target)) {
            result = Math.min(result, count);
            return;
        }

        for(int idx = 0; idx < str.length(); ++idx) {
            StringBuilder temp = new StringBuilder(str);
            for (char c = 'a'; c <= 'z'; c++) {
                String next = temp.replace(idx, idx + 1, String.valueOf(c)).toString();

                if (m.containsKey(next) && !visited[m.get(next)]) {
                    visited[m.get(next)] = true;
                    find(new StringBuilder(next), count + 1, visited, target);
                    visited[m.get(next)] = false;
                }
            }
        }
    }
}
