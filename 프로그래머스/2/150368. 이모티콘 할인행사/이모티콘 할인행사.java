import java.util.*;

public class Solution {

    public static int[] discount = {40, 30, 20, 10};
    public static int[] answer = {0, 0};
    
    public static int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[users.length], emoticons, users);
        return answer;
    }

    public static void dfs(int depth, int[] totalMoney, int[] emoticons, int[][] users) {
        if (depth == emoticons.length) {
            int pCount = 0;
            int totalCost = 0;

            for(int i = 0; i < users.length; ++i) {
                if (users[i][1] <= totalMoney[i]) {
                    pCount++;
                } else {
                    totalCost += totalMoney[i];
                }
            }

            if (pCount > answer[0]) {
                answer[0] = pCount;
                answer[1] = totalCost;
            } else if (pCount == answer[0] && totalCost > answer[1]) {
                answer[1] = totalCost;
            }
            return;
        }

        for(int i = 0; i < 4; ++i) {
            for (int j = 0; j < users.length; j++) {
                if(discount[i] >= users[j][0]) {
                    totalMoney[j] += (emoticons[depth] * (100 - discount[i])) / 100;
                }
            }

            dfs(depth + 1, totalMoney, emoticons, users);

            for (int j = 0; j < users.length; j++) {
                if(discount[i] >= users[j][0]) {
                    totalMoney[j] -= (emoticons[depth] * (100 - discount[i])) / 100;
                }
            }
        }
    }
}
