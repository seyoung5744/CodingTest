import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        int targetIdx = 0;

        while (idx1 < cards1.length && idx2 < cards2.length) {
            if (targetIdx < goal.length && goal[targetIdx].equals(cards1[idx1])) {
                idx1++;
                targetIdx++;
            }
            else if (targetIdx < goal.length && goal[targetIdx].equals(cards2[idx2])) {
                idx2++;
                targetIdx++;
            } else {
                idx2++;
                targetIdx++;
            }
        }

        while (idx1 < cards1.length && targetIdx < goal.length) {
            if (goal[targetIdx].equals(cards1[idx1])) {
                idx1++;
                targetIdx++;
            } else {
                break;
            }
        }
        while (idx2 < cards2.length && targetIdx < goal.length) {
            if (goal[targetIdx].equals(cards2[idx2])) {
                idx2++;
                targetIdx++;
            } else {
                break;
            }
        }
        if (idx1 == goal.length || idx2 == goal.length) return "Yes";
        return idx1 + idx2 == goal.length ? "Yes" : "No";
    }
}