import java.util.*;

public class Solution {

    public static final Map<String, Set<Integer>> matches = new HashMap<>();
    public static Set<List<String>> result = new HashSet<>();

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].matches(banned_id[i])) {
                    Set<Integer> list = matches.getOrDefault(banned_id[i], new HashSet<>());
                    list.add(j);
                    matches.put(banned_id[i], list);
                }
            }
        }

        combination(banned_id, 0, new boolean[user_id.length], user_id, new ArrayList<>());
        return result.size();
    }

    public static void combination(String[] banned, int banIdx, boolean[] visited, String[] users, List<String> candidate) {

        if(banIdx >= banned.length) {
            Collections.sort(candidate);
            result.add(candidate);
            return;
        }

        for(int user : matches.get(banned[banIdx])) {
            if(visited[user]) continue;
            visited[user] = true;
            candidate.add(users[user]);
            combination(banned, banIdx + 1, visited, users, candidate);
            visited[user] = false;
            candidate.remove(users[user]);
        }
    }
}
