import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            answer[index++] = iterator.next();
        }
        Arrays.sort(answer);
        return answer;
    }

}
