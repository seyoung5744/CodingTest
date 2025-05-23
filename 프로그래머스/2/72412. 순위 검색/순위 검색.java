import java.util.*;
import java.util.function.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoreMap = buildScoreMap(info);

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            answer[i] = count(query[i], scoreMap);
        }
        return answer;
    }

    private int count(String query, Map<String, List<Integer>> scoreMap) {
        String[] tokens = query.split(" (and)?");
        String key = "";
        for (int i = 0; i < tokens.length - 1; i++) {
            key += tokens[i];
        }

        if (!scoreMap.containsKey(key)) {
            return 0;
        }
        List<Integer> scores = scoreMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(score, scores);
    }

    private int binarySearch(int target, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (start < end) {
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

    public Map<String, List<Integer>> buildScoreMap(String[] info) {
        Map<String, List<Integer>> scoreMap = new HashMap<>();
        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            generateKey(0, "", tokens, key -> {
                scoreMap.putIfAbsent(key, new ArrayList<>());
                scoreMap.get(key).add(score);
            });
        }

        for (List<Integer> value : scoreMap.values()) {
            Collections.sort(value);
        }
        return scoreMap;
    }

    public void generateKey(int idx, String prefix, String[] tokens, Consumer<String> action) {
        if (idx == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        generateKey(idx + 1, prefix + tokens[idx], tokens, action);
        generateKey(idx + 1, prefix + "-", tokens, action);
    }
}