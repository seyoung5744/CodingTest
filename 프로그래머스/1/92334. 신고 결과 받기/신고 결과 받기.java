import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> reportedCount = new HashMap<>();
        Map<String, Set<String>> reportList = new HashMap<>();

        for (String report : reports) {
            String[] tokens = report.split(" ");

            reportList.computeIfAbsent(tokens[0], c -> new HashSet<>()).add(tokens[1]);
            reportedCount.computeIfAbsent(tokens[1], c -> new HashSet<>()).add(tokens[0]);
        }
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if (reportList.containsKey(id)) {
                Set<String> reported = reportList.get(id);
                for (String report : reported) {
                    if (reportedCount.containsKey(report)) {
                        if (reportedCount.get(report).size() >= k) {
                            answer[i]++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}