import java.util.*;

public class Solution {

    private static final Map<String, Integer> mineralIdxTable = Map.of(
            "diamond", 0,
            "iron", 1,
            "stone", 2
    );
    private static final int[][] costTable = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
    };

    public static int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = 0;
        for (int i = 0; i < picks.length; i++) {
            totalPicks += picks[i];
        }
        miningMinerals(0, 0, 0, 0, totalPicks, picks, minerals);
        return answer;
    }

    private void miningMinerals(int pickIdx, int mineralIdx, int fatigue, int count, int totalPicks, int[] picks, String[] minerals) {

        if (mineralIdx >= minerals.length || (count == 0 && totalPicks == 0)) {
            answer = Math.min(answer, fatigue);
            return;
        }

        int mineral = mineralIdxTable.get(minerals[mineralIdx]);

        if (mineralIdx % 5 != 0) {
            int cost = costTable[pickIdx][mineral];
            miningMinerals(pickIdx, mineralIdx + 1, fatigue + cost, count - 1, totalPicks, picks, minerals);
            return;
        } else {
            for (int i = 0; i < picks.length; i++) {
                if (picks[i] == 0) continue;

                picks[i]--;
                int cost = costTable[i][mineral];
                miningMinerals(i, mineralIdx + 1, fatigue + cost, 4, totalPicks - 1, picks, minerals);
                picks[i]++;
            }
        }
    }
}
