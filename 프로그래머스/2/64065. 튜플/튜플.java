import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static int[] solution(String s) {
        Set<Integer> set = new HashSet<>();

        List<List<Integer>> tokens = split(s);
        tokens.sort(Comparator.comparing(List::size));
        
        int[] answer = new int[tokens.size()];
        int idx = 0;
        for(List<Integer> token : tokens) {
            for(int num : token) {
                if(set.add(num)) {
                    answer[idx++] = num;
                }
            }
        }

        return answer;
    }

    private static List<List<Integer>> split(String s) {
        List<List<Integer>> result = new ArrayList<>();
        s = s.replace("{{", "").replace("}}", "");
        String[] tokens = s.split("},\\{");
        for (String token : tokens) {
            result.add(
                Arrays.stream(token.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
        }
        return result;
    }
}
