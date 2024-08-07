import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static double[] solution(int k, int[][] ranges) {

        List<Double> areas = new ArrayList<>();
        int init = k;

        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }

            double area = (double) (k + init) / 2;
            areas.add(area);
            init = k;
        }

        int n = areas.size();
        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];

            int start = range[0];
            int end = 0;
            if(range[1] <= 0) {
                end = n + range[1];
            }

            if(start < end) {
                for (int j = start; j < end; j++) {
                    answer[i] += areas.get(j);
                }
            }else if(start > end){
                answer[i] = -1;
            }
        }
        return answer;
    }

}
