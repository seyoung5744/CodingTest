import java.util.*;

public class Solution {

    public static int answer = Integer.MAX_VALUE;
    public static Map<String, Integer> map = new HashMap<>();
    public static int[][] cost = new int[][]{
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };

    public static int solution(int[] picks, String[] minerals) {
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);

        int totalPicksCount = 0;
        for (int i = 0; i < picks.length; i++) {
            totalPicksCount += picks[i];
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;

            picks[i]--;
            dfs(minerals, picks, i, 0, totalPicksCount - 1, 5, 0);
            picks[i]++;
        }

        return answer;
    }

    public static void dfs(String[] minerals, int[] picks, int currentPick,
        int mineralIdx, int totalPicks, int curPickCount, int tired) {
        if (mineralIdx >= minerals.length || (totalPicks == 0 && curPickCount == 0))
        {
            if (tired < answer)
            {
                answer = tired;
            }

            return;
        }

        if (curPickCount > 0)
        {
            int m = map.get(minerals[mineralIdx]);
            dfs(minerals, picks, currentPick, mineralIdx+1, totalPicks , curPickCount-1, tired + cost[currentPick][m]);

            return;
        }

        for(int i = 0; i < 3; ++i)
        {
            if (picks[i] == 0) continue;

            picks[i]--;
            dfs(minerals, picks, i, mineralIdx, totalPicks - 1, 5, tired);
            picks[i]++;
        }

    }

   
}
