import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        String[] banned = convertPattern(banned_id);
        List<List<String>> banList = new ArrayList<>();
        for (int i = 0; i < banned.length; i++) {
            banList.add(new ArrayList<>());
        }

        for (int i = 0; i < banned.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].matches(banned[i])) {
                    banList.get(i).add(user_id[j]);
                }
            }
        }

        Set<Set<String>> result = new HashSet<>();
        count(0, banList, new HashSet<>(), result);
        return result.size();
    }

    public void count(int idx, List<List<String>> banList, Set<String> temp, Set<Set<String>> result) {
        if (idx == banList.size()) {
            result.add(new HashSet<>(temp));
            return;
        }

        for (String ban : banList.get(idx)) {
            if (temp.contains(ban)) continue;
            temp.add(ban);
            count(idx + 1, banList, temp, result);
            temp.remove(ban);
        }
    }

    public static String[] convertPattern(String[] bannedId) {
        return Arrays.stream(bannedId)
                .map(s -> s.replace('*', '.'))
                .toArray(String[]::new);
    }
}