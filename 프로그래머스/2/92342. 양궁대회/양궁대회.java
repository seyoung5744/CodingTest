import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int[] result = new int[]{-1};
    public static int max = 0;

    public static int[] solution(int n, int[] info) {
        dfs(0, 0, n, new int[11], info);
        return result;
    }

    public static void dfs(int used, int curIdx, int n, int[] candidate, int[] info) {
        if (curIdx == info.length) {

            if (used < n) {
                candidate[curIdx - 1] += (n - used);
            }

            int compare = compare(candidate, info);

            if (compare > max) {
                result = Arrays.copyOf(candidate, candidate.length);
                max = compare;
            } else if (compare == max) {
                if (compare == 0) {
                    return;
                }

                for (int i = 10; i >= 0; --i) {
                    if (result[i] < candidate[i]) {
                        result = Arrays.copyOf(candidate, candidate.length);
                        break;
                    } else if (result[i] > candidate[i]) {
                        break;
                    }
                }
            }

            return;
        }

        if (n - used >= info[curIdx] + 1) {
            candidate[curIdx] = info[curIdx] + 1;
            dfs(used + info[curIdx] + 1, curIdx + 1, n, Arrays.copyOf(candidate, candidate.length), info);
            candidate[curIdx] = 0;
        }

        dfs(used, curIdx + 1, n, Arrays.copyOf(candidate, candidate.length), info);
    }

    public static int compare(int[] candidate, int[] info) {

        int lion = 0;
        int apeach = 0;

        for (int i = 0; i < 11; i++) {
            if (candidate[i] > info[i]) {
                lion += 10 - i;
            } else if (info[i] != 0) {
                apeach += 10 - i;
            }
        }

        return lion - apeach;
    }
}
