import java.util.Arrays;

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < lost.length) {
                students[lost[i] - 1] -= 1;
            }
            if (i < reserve.length) {
                students[reserve[i] - 1] += 1;
            }
            students[i] += 1;
        }
        
        for (int i = 0; i < lost.length; i++) {
            int idx = lost[i] - 1;

            if (idx > 0 && students[idx - 1] > 1) {
                students[idx] = 1;
                students[idx- 1] -= 1;
            } else if (idx < n-1 && students[idx + 1] > 1) {
                students[idx] = 1;
                students[idx + 1] -= 1;
            }
        }

        return (int)Arrays.stream(students)
            .filter(s -> s > 0)
            .count();

    }

}