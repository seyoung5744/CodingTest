import java.util.Arrays;

public class Solution {

    public static int[] discount = {40, 30, 20, 10};
    public static int[] answer = {0, 0};
    public static int[] solution(int[][] users, int[] emoticons) {

        int[] dis = new int[emoticons.length];
        dfs(0, dis, emoticons, users);


        return answer;
    }

    public static void dfs(int depth, int[] dis, int[] emoticons, int[][] users)
    {
        if (depth == emoticons.length)
        {
            int pCount = 0;
            int totalCost = 0;
            for(int i = 0; i < users.length; ++i)
            {
                boolean flag = false;
                int cost = 0;
                for(int j = 0; j < emoticons.length; ++j)
                {
                    if (users[i][0] <= discount[dis[j]])
                    {
                        cost += emoticons[j] * ((double)(100 - discount[dis[j]]) / 100);
                    }

                    if (cost >= users[i][1])
                    {
                        flag = true;
                        break;
                    }
                }

                if (flag)
                {
                    pCount++;
                }
                else
                {
                    totalCost += cost;
                }

            }

            if (pCount > answer[0])
            {
                answer[0] = pCount;
                answer[1] = totalCost;
            }
            else if (pCount == answer[0] && totalCost > answer[1])
            {
                answer[1] = totalCost;
            }
            return;
        }

        for(int i = 0; i < 4; ++i)
        {
            dis[depth] = i;
            dfs(depth + 1, dis, emoticons, users);
        }
    }

}
