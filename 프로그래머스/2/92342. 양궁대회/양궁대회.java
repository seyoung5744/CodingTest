import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<int[]> results = new ArrayList<>();
    public static final int[] SCORES = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];

        shoot(n, new int[11], 0, info);

        if (results.isEmpty()) {
            return new int[]{-1};
        }

        int max = Integer.MIN_VALUE;
        for (int[] candidate : results) {
            int apachScore = 0;
            int lionScore = 0;
            for (int i = 0; i < candidate.length; i++) {
                if (candidate[i] > info[i]) {
                    lionScore += SCORES[i];
                } else {
                    if (info[i] != 0) {
                        apachScore += SCORES[i];
                    }
                }
            }

            if (lionScore - apachScore > max) {
                max = Math.max(max, lionScore - apachScore);
                answer = candidate;
            } else if (lionScore - apachScore == max) {
                for (int i = info.length - 1; i >= 0; i--) {
                    if (answer[i] == candidate[i]) {
                        continue;
                    }
                    if (answer[i] < candidate[i]) {
                        answer = candidate;
                    }
                    break;
                }
            }


        }
        return answer;
    }

    public static void shoot(int n, int[] candidate, int target, int[] info) {
        if (n <= 0) { // 화살 다 쏘면 결과 저장?
            int apachScore = 0;
            int lionScore = 0;
            for (int i = 0; i < candidate.length; i++) {
                if (candidate[i] > info[i]) {
                    lionScore += SCORES[i];
                } else {
                    if (info[i] != 0) {
                        apachScore += SCORES[i];
                    }
                }
            }
            if (lionScore > apachScore) {
                results.add(Arrays.copyOf(candidate, candidate.length));
            }
            return;
        }

        if (target >= info.length) {
            return;
        }

        if (n > info[target]) { // 남은 화살 수가 해당 target 보다 크면
            // 해당 점수 얻어보고
            n -= info[target] + 1;
            candidate[target] = info[target] + 1;
            shoot(n, candidate, target + 1, info);

            // 해당 점수 빼보고
            n += info[target] + 1;
            candidate[target] = 0;
            shoot(n, candidate, target + 1, info);
        } else { // 남은 화살 수가 target 보다 작거나 같으면
            // 다음 target으로
            candidate[target] = n;
            n -= n;
            shoot(n, candidate, target + 1, info);

            n += candidate[target];
            candidate[target] = 0;
            shoot(n, candidate, target + 1, info);
        }
    }
}
