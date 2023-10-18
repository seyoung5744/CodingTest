import java.util.*;

public class Solution {

    private static final int DAY_OF_MONTH = 28;
    private static final int MONTH_OF_YEAR = 12;
    
    public static int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] termArr = term.split(" ");
            map.put(termArr[0], Integer.parseInt(termArr[1]) * DAY_OF_MONTH);
        }

        int todayDays = calculateDay(Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray());

        for (int i = 0; i < privacies.length; i++) {

            String[] privacyArr = privacies[i].split(" ");

            int privacyDays = calculateDay(Arrays.stream(privacyArr[0].split("\\.")).mapToInt(Integer::parseInt).toArray());

            String key = privacyArr[1];
            privacyDays += map.get(key) - 1;

            if (todayDays > privacyDays) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int calculateDay(int[] dates) {
        return (dates[0] * MONTH_OF_YEAR * DAY_OF_MONTH) + (dates[1] * DAY_OF_MONTH) + dates[2];
    }

}
