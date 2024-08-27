
import java.util.*;

public class Solution {

    public static List<List<String>> graph = new ArrayList<>();
    public static Map<String, Integer> index = new HashMap<>();
    public static Map<Integer, String> airport = new HashMap<>();

    public static String[] solution(String[][] tickets) {
        Set<String> count = new HashSet<>();
        for (String[] ticket : tickets) {
            count.add(ticket[0]);
            count.add(ticket[1]);
        }

        int idx = 0;
        for (String str : count) {
            airport.put(idx, str);
            index.put(str, idx);
            idx++;
            graph.add(new ArrayList<>());
        }

        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            graph.get(index.get(start)).add(end);
        }

        int start = index.get("ICN");
        
        List<String> result = new ArrayList<>();
        result.add("ICN");
        
        dfs(start, tickets, new boolean[tickets.length], 0, result);

        answer.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
        return answer.get(0).stream().toArray(String[]::new);
    }

    public static List<List<String>> answer = new ArrayList<>();
    
    public static void dfs(int curAirport, String[][] tickets, boolean[] used, int useCnt, List<String> result) {

        if (useCnt >= tickets.length) {
            answer.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            int start = index.get(tickets[i][0]);

            if (start != curAirport) {
                continue;
            }

            if (used[i]) {
                continue;
            }

            used[i] = true;
            result.add(tickets[i][1]);
            dfs(index.get(tickets[i][1]), tickets, used, useCnt + 1, result);
            used[i] = false;
            result.remove(result.size() - 1);
        }
    }

}
