import java.util.*;

public class Solution {

    public static int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] termArr = term.split(" ");
            map.put(termArr[0], Integer.parseInt(termArr[1]) * 28);
        }

        int[] dates = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(dates));
        int todays = extracted(dates);
        int index = 1;

        for(String privacy : privacies) {
            String[] privacyArr = privacy.split(" ");
            dates = Arrays.stream(privacyArr[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            String key = privacyArr[1];

            int extracted = extracted(dates);

            extracted += map.get(key) - 1;

            if (todays > extracted)
            {
                answer.add(index);
            }

            index++;
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int extracted(int[] dates) {
        int year = 12 * 28;
        return  (dates[0] * year) + (dates[1] * 28) + dates[2];
    }
}
