import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();

        List<List<Integer>> tokens = split(s);
        tokens.sort(Comparator.comparing(List::size));

        for(List<Integer> token : tokens) {
            for(int num : token) {
                if(!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
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
