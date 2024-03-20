import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int NUM;

    public static int solution(int N, int target) {
        int answer = -1;
    

        ArrayList<Integer>[] dp = new ArrayList[9];

        String temp = String.valueOf(N);

        for (int i = 1; i <= 8; i++) {
            
            if(Integer.parseInt(temp) == target)
                return i;
            
            dp[i] = new ArrayList<>();
            dp[i].add(Integer.parseInt(temp));
            temp += String.valueOf(N);
        }

        for (int i = 2; i <= 8 ; i++) {
            for(int end = 1; end < i; ++end) {
                for (int j = 0; j < dp[end].size(); ++j) {
                    for (int k = 0; k < dp[i - end].size(); ++k) {
                        if (dp[end].get(j) + dp[i-end].get(k) == target)
                            return i;

                        if (dp[end].get(j) + dp[i-end].get(k) > 0)
                            dp[i].add(dp[end].get(j) + dp[i-end].get(k));

                        if (dp[end].get(j) - dp[i-end].get(k) == target)
                            return i;
                        
                        if (dp[end].get(j) - dp[i-end].get(k) > 0)
                            dp[i].add(dp[end].get(j) - dp[i-end].get(k));

                        if (dp[end].get(j) * dp[i-end].get(k) == target)
                            return i;
                        
                        if (dp[end].get(j) * dp[i-end].get(k) > 0)
                            dp[i].add(dp[end].get(j) * dp[i-end].get(k));

                        if (dp[end].get(j) / dp[i-end].get(k) == target)
                            return i;
                        
                        if (dp[end].get(j) / dp[i-end].get(k) > 0)
                            dp[i].add(dp[end].get(j) / dp[i-end].get(k));
                    }
                }
            }
        }
        
        return -1;
    }

    public static void recursive(String str, int cnt) {
        if (cnt == 5) {
            return;
        }

        System.out.println(str);
        recursive(str + "+" + NUM, cnt + 1);
        recursive(str + "-" + NUM, cnt + 1);
        recursive(str + "*" + NUM, cnt + 1);
        recursive(str + "/" + NUM, cnt + 1);
        recursive(str + NUM, cnt + 1);

    }
}
