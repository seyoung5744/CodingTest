
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                
                if (o1[col - 1] == o2[col - 1])
                    return o2[0] - o1[0];

                return o1[col - 1] - o2[col - 1];
            }
        });

        int[] nums = new int[row_end - row_begin + 1];
        int idx = 0;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            for (int j = 0; j < data[i].length; j++) {
                nums[idx] += data[i][j] % (i + 1);
            }
            idx++;
        }


        answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer ^= nums[i];
        }
        return answer;
    }
}