import java.util.*;
import java.util.function.Consumer;

public class Solution {

    public static int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoreMap(info);

        int[] answer = new int[query.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = count(query[i], scoresMap);
        }

        return answer;
    }

    public static int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) {
            return 0;
        }
        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(scores, score);
    }

    public static int binarySearch(List<Integer> scores, int target) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < target) {
            return scores.size();
        }

        return start;
    }

    public static Map<String, List<Integer>> buildScoreMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);

            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        return scoresMap;
    }

    public static void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

}
