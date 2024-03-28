import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
            .map(banned -> banned.replace('*', '.'))
            .map(banned -> Arrays.stream(user_id)
                .filter(user -> user.matches(banned))
                .toArray(String[]::new))
            .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, bans, new HashSet<>(), banSet);

        return banSet.size();
    }

    public static void count(int index, String[][] bans, Set<String> banned, Set<Set<String>> banSet) {
        if(index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for(String id : bans[index]) {
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, bans, banned, banSet);
            banned.remove(id);
        }
    }


}
