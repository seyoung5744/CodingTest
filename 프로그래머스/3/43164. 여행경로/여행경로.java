
import java.util.*;

class Solution {
    public static List<String> result = new ArrayList<>();
    public static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs("ICN", 0, "ICN", tickets);

        Collections.sort(result);
        return result.get(0).split("_");
    }

    public static void dfs(String start, int ticketCnt, String word, String[][] tickets) {

        if(ticketCnt == tickets.length) {
            result.add(word);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], ticketCnt + 1, word + "_" + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}