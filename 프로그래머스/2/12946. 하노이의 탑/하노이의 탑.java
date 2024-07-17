import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<int[]> answer = new ArrayList<>();

    public static int[][] solution(int n) {
        recursive(n, 1, 3, 2);
        return answer.stream().toArray(int[][]::new);
    }

    public static void recursive(int n, int start, int end, int mid) {

        if (n == 0) {
            return;
        }

        recursive(n - 1, start, mid, end);
        answer.add(new int[]{start, end});

        recursive(n - 1, mid, end, start);
    }

}
