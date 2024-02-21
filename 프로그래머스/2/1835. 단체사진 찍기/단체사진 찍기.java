import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static List<Map<Character, Integer>> candidates = new ArrayList<>();
    public static String[] rule;
    public static int answer;

    public static int solution(int n, String[] data) {
        answer = 0;
        rule = data;

        boolean[] visited = new boolean[8];
        Map<Character, Integer> persons = new HashMap<>() {{
            put('A', 0);
            put('C', 1);
            put('F', 2);
            put('J', 3);
            put('M', 4);
            put('N', 5);
            put('R', 6);
            put('T', 7);
        }};

        dfs(0, persons, visited);

        return answer;
    }

    public static void dfs(int p, Map<Character, Integer> candidate, boolean[] visited) {

        if (p >= people.length) {
            if (check(candidate)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; ++i) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            candidate.put(people[p], i);
            dfs(p + 1, new HashMap<>(candidate), visited);
            visited[i] = false;
        }
    }

    public static boolean check(Map<Character, Integer> candidate) {
        for (String d : rule) {
            char sign = d.charAt(3);
            int distance = Integer.parseInt(d.substring(4));
            int p1 = candidate.get(d.charAt(0));
            int p2 = candidate.get(d.charAt(2));

            int abs = Math.abs(p2 - p1) - 1;

            switch (sign) {
                case '=':
                    if (abs != distance) {
                        return false;
                    }
                    break;
                case '>':
                    if (abs <= distance) {
                        return false;
                    }
                    break;
                case '<':
                    if (abs >= distance) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

}
