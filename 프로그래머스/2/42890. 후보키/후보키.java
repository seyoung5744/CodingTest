import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static String[][] tables;
    public static List<Set<Character>> candidateKeys;

    public static int solution(String[][] relation) {
        int answer = 0;
        tables = relation;
        candidateKeys = new ArrayList<>();

        String columns = "";
        for (int i = 0; i < relation[0].length; i++) {
            columns += i;
        }
        for (int len = 1; len <= relation[0].length; len++) {
            generate(columns, new HashSet<>(), len);
        }

        return candidateKeys.size();
    }

    public static void generate(String columns, Set<Character> out, int len) {

        if (len == 0 && isUnique(out) && isMinimal(out)) {
            candidateKeys.add(out);
            return;
        }

        for (int i = 0; i < columns.length(); i++) {
            Set<Character> newOut = new HashSet<>(out);
            newOut.add(columns.charAt(i));
            generate(columns.substring(i + 1), newOut, len - 1);
        }
    }


    public static boolean isUnique(Set<Character> key) {
        Set<String> set = new HashSet<>();
        for (String[] row : tables) {
            String projection = "";
            for (char col : key) {
                projection += row[col - '0'];
            }
            if (set.contains(projection)) {
                return false;
            } else {
                set.add(projection);
            }
        }
        return true;
    }


    private static boolean isMinimal(Set<Character> out) {
        for (Set<Character> candidateKey : candidateKeys) {
            if (out.containsAll(candidateKey)) {
                return false;
            }
        }
        return true;
    }
}
