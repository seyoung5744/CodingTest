import java.util.*;

public class Solution {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        int n = 0;
        List<Integer> point = new ArrayList<>();
        while(k > 1) {
            point.add(k);
            if(k % 2 == 0) {
                k /= 2;
            }else {
                k = k * 3 + 1;
            }
            n++;
        }
        point.add(k);


        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            System.out.println(start + ", " + end);
            if(end < start) {
                answer[i] = -1;
            } else {
                double sum = 0;
                for (int j = start; j < end; j++) {
                    sum += (double)(point.get(j) + point.get(j + 1)) / 2;
                }
                answer[i] = sum;
            }
        }
        return answer;
    }

}
