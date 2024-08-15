import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Integer[] boxedA = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        Integer[] boxedB = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < boxedA.length) {
            if (boxedB[bIdx] > boxedA[aIdx]) {
                answer++;
                bIdx++;
            }

            aIdx++;
        }

        return answer;
    }
}